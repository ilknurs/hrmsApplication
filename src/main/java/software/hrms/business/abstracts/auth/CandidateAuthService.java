package software.hrms.business.abstracts.auth;

import software.hrms.core.utilities.results.Result;
import software.hrms.entities.dtos.RegisterForCandidateDto;

public interface CandidateAuthService {
	
    Result register(RegisterForCandidateDto registerForCandidateDto);
   
}
