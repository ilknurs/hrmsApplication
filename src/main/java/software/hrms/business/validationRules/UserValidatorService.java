package software.hrms.business.validationRules;

import software.hrms.core.utilities.results.Result;
import software.hrms.entities.abstracts.User;

public interface UserValidatorService {
    Result userNullCheck(User user);
}
