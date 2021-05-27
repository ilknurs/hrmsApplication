package software.hrms.business.abstracts.auth;

import software.hrms.core.utilities.results.Result;
import software.hrms.entities.dtos.RegisterForEmployerDto;

public interface EmployerAuthService {
	
	Result register(RegisterForEmployerDto registerForEmployerDto);

	

}
