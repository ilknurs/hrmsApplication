package software.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.EmployerService;
import software.hrms.business.validationRules.EmployerValidatorService;
import software.hrms.dataAcces.abstracts.EmployerDao;
import software.hrms.dataAcces.abstracts.UserDao;
import software.hrms.entities.concretes.Employer;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService {
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(UserDao<Employer> userDao) {
		super(userDao);
		this.employerDao = (EmployerDao) userDao;
	}

}
