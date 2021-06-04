package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {

	DataResult<List<CandidateLanguage>> getAll();

	DataResult<List<CandidateLanguage>> getByCandidate_id(int candidateId);

	Result add(CandidateLanguage candidateLanguage);

}
