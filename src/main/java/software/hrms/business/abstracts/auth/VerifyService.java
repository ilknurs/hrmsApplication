package software.hrms.business.abstracts.auth;

import software.hrms.core.utilities.results.Result;

public interface VerifyService {
	
    Result verify(int userId, String activationCode);
}