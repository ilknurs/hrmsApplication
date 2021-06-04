package software.hrms.business.validationRules;

import software.hrms.core.entities.User;
import software.hrms.core.utilities.results.Result;

public interface UserValidatorService {
    Result userNullCheck(User user);
}
