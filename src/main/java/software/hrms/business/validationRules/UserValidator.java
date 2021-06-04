package software.hrms.business.validationRules;

import software.hrms.business.constant.Messages;
import software.hrms.core.entities.User;
import software.hrms.core.utilities.results.ErrorResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessResult;

public class UserValidator implements UserValidatorService {

	public Result userNullCheck(User user) {
		if ((user.getEmail() == null || user.getEmail().isBlank())
				&& (user.getPassword() == null || user.getPassword().isBlank())) {
			return new ErrorResult(Messages.notNull);
		}
		return new SuccessResult();
	}
}