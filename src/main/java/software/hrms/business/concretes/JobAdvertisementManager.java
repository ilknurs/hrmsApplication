package software.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import software.hrms.business.abstracts.JobAdvertisementService;
import software.hrms.business.constant.Messages;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.JobAdvertisementDao;
import software.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {

		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		List<JobAdvertisement> result = this.jobAdvertisementDao.findAll();
		return new SuccessDataResult<List<JobAdvertisement>>(result);
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive() {
		List<JobAdvertisement> result = this.jobAdvertisementDao.findAllByIsActiveTrue();
		return new SuccessDataResult<List<JobAdvertisement>>(result, Messages.jobAdvertisementListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByLastApplyDate() {
		List<JobAdvertisement> result = this.jobAdvertisementDao.findAllByIsActiveOrderByLastApplyDateDesc(true);
		return new SuccessDataResult<List<JobAdvertisement>>(result, Messages.jobAdvertisementListedByLastDate);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveAndEmployerId(int id) {
		List<JobAdvertisement> result = this.jobAdvertisementDao.getEmployersActiveJobAdvertisement(id);
		return new SuccessDataResult<List<JobAdvertisement>>(result, Messages.jobAdvertisementListedByCompany);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent());
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult();
	}

	@PutMapping()
	public Result update(int jobAdvertisemenetId, JobAdvertisement jobAdvertisemenet) {
		JobAdvertisement result = this.jobAdvertisementDao.findById(jobAdvertisemenetId).get();
		result.setActive(jobAdvertisemenet.isActive());
		if (jobAdvertisemenet.getLastApplyDate().isBefore(LocalDate.now())) {
			result.isActive();
		}
		return new SuccessResult();

	}

}
