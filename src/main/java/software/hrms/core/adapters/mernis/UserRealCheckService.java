package software.hrms.core.adapters.mernis;

import software.hrms.core.adapters.models.MernisPerson;

public interface UserRealCheckService {
	boolean validate(MernisPerson person);

}
