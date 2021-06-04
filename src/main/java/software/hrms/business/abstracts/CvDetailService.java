package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CvDetail;

public interface CvDetailService {

	DataResult<List<CvDetail>> getAll();

	DataResult<CvDetail> getByCandidate_id(int candidate);

	Result add(CvDetail cvDetail);

}
