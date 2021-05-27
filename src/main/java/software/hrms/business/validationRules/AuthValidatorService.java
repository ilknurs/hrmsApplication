package software.hrms.business.validationRules;

import software.hrms.core.utilities.results.Result;

public interface AuthValidatorService {
	
    Result isPasswordConfirmed(String password, String confirmPassword);
}