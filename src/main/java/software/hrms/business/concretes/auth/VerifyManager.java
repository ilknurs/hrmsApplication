package software.hrms.business.concretes.auth;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.ActivationCodeService;
import software.hrms.business.abstracts.auth.VerifyService;
import software.hrms.business.constant.Messages;
import software.hrms.core.utilities.results.ErrorResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.entities.concretes.ActivationCode;

@Service
public class VerifyManager implements VerifyService {

	private ActivationCodeService activationCodeService;

	@Autowired
	public VerifyManager(ActivationCodeService activationCodeService) {
		this.activationCodeService = activationCodeService;
	}

	public Result verify(int userId, String activationCode) {
		Optional<ActivationCode> activation = activationCodeService.getByUserId(userId).getData();
		Result result = subVerify(activation, activationCode);
		if (!result.isSuccess()) {
			return result;
		}

		activation.get().setConfirmed(true);
		activation.get().setActivationDate(LocalDateTime.now());
		activationCodeService.update(activation.get());
		return new SuccessResult(Messages.codeVerified);
	}

	private Result subVerify(Optional<ActivationCode> activation, String activationCode) {
		if (activation.isEmpty()) {
			return new ErrorResult(Messages.codeNotFound);
		}
		if (activation.get().isConfirmed()) {
			return new ErrorResult(Messages.activationExist);
		}
		if (activation.get().getExpirationDate().isBefore(LocalDateTime.now())) {
			return new ErrorResult(Messages.codeExpired);
		}
		if (!activation.get().getActivationCode().equals(activationCode)) {
			return new ErrorResult(Messages.codeNotEqual);
		}
		return new SuccessResult();
	}
}
