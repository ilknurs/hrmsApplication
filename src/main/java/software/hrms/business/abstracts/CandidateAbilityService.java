package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidateAbility;

public interface CandidateAbilityService {
	
	DataResult<List<CandidateAbility>> getAll();
	
	DataResult<List<CandidateAbility>> getByCandidate_id(int candidateId);
	
	Result add(CandidateAbility candidateAbility);

}
