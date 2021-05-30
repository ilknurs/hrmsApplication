package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> findAllByIsActive();

	DataResult<List<JobAdvertisement>> getByLastApplyDate();

	DataResult<List<JobAdvertisement>> getByisActiveAndEmployerId(int id);

	DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);

	public Result add(JobAdvertisement jobAdvertisement);

	Result update(int jobAdvertisemenetId, JobAdvertisement jobAdvertisemenet);
}
