package software.hrms.business.concretes.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.ActivationCodeService;
import software.hrms.business.abstracts.EmployerService;
import software.hrms.business.abstracts.auth.EmployerAuthService;
import software.hrms.business.constant.Messages;
import software.hrms.business.validationRules.AuthValidatorService;
import software.hrms.core.utilities.business.BusinessEngine;
import software.hrms.core.utilities.email.EmailSenderService;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.core.utilities.verificationTool.CodeGenerator;
import software.hrms.entities.concretes.ActivationCode;
import software.hrms.entities.concretes.Employer;
import software.hrms.entities.dtos.RegisterForEmployerDto;

@Service
public class EmployerAuthManager implements EmployerAuthService {
	private AuthValidatorService authValidatorService;
	private EmployerService employerService;
	private ActivationCodeService activationCodeService;
	private EmailSenderService emailSenderService;

	@Autowired
	public EmployerAuthManager(EmployerService employerService, AuthValidatorService authValidatorService) {
		this.authValidatorService = authValidatorService;
		this.employerService = employerService;
	}

	@Override
	public Result register(RegisterForEmployerDto registerForEmployerDto) {
		Result result = BusinessEngine.run(authValidatorService.isPasswordConfirmed(
				registerForEmployerDto.getPassword(), registerForEmployerDto.getConfirmPassword()));
		if (!result.isSuccess()) {
			return result;
		}

		// dto candidate'e maplendi.
		Employer employer = new Employer(registerForEmployerDto.getCompanyName(),
				registerForEmployerDto.getPhoneNumber(), registerForEmployerDto.getWebAdress());

		Result addResult = employerService.add(employer);
		if (!addResult.isSuccess()) {
			return addResult;
		}
		String code = CodeGenerator.generateUuidCode();
		ActivationCode activationCode = new ActivationCode(employer.getId(), code);
		Result activationResult = activationCodeService.add(activationCode);

		if (activationResult.isSuccess()) {
			return activationResult;

		}

		emailSenderService.send("Doğrulama için linke tıklayınız .." + code);
		return new SuccessResult(Messages.userAdded);
	}

}
