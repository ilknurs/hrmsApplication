package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidateWorkplaceJobPosition;

public interface CandidateWorkplaceJobPositionService {

	DataResult<List<CandidateWorkplaceJobPosition>> getAll();

	DataResult<List<CandidateWorkplaceJobPosition>> getByCandidate_id(int candidateId);

	Result add(CandidateWorkplaceJobPosition candidateWorkplaceJobPosition);

}
