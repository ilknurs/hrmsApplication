package software.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.ActivationCodeService;
import software.hrms.business.constant.Messages;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.ActivationCodeDao;
import software.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService {
    private ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public DataResult<List<ActivationCode>> getAll() {
        return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(),Messages.activationCodeListed);
    }

    @Override
    public Result add(ActivationCode activationCode) {
        activationCode.setExpirationDate(LocalDateTime.now().plusMinutes(15));
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeAdded);
    }

    @Override
    public Result update(ActivationCode activationCode) {
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeUpdated);
    }

	@Override
	public DataResult<Optional<ActivationCode>> getByUserId(int userId) {
		return new SuccessDataResult<Optional<ActivationCode>>(activationCodeDao.findByUserId(userId));
	}
}