package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Candidate;


public interface CandidateService extends UserService<Candidate> {
	DataResult<List<Candidate>> getAll();
    Result add(Candidate jobPosition);

}
