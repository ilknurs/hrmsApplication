package software.hrms.business.validationRules;

import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Candidate;

public interface CandidateValidatorService {
	Result candidateNullCheck(Candidate candidate);
}
