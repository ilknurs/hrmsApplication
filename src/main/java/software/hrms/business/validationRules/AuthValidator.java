package software.hrms.business.validationRules;

import org.springframework.stereotype.Component;

import software.hrms.business.constant.Messages;
import software.hrms.core.utilities.results.ErrorResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessResult;

@Component
public class AuthValidator implements AuthValidatorService {
    public Result isPasswordConfirmed(String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            return new SuccessResult();
        }
        return new ErrorResult(Messages.passwordNotConfirmed);
    }
}
