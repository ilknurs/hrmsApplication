package software.hrms.business.validationRules;

import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Employer;

public interface EmployerValidatorService {
	Result employerNullCheck(Employer employer);

	Result isEmailDomainCheck(Employer employer);
}