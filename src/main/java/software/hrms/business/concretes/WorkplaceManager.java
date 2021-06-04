package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.WorkplaceService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.WorkplaceDao;
import software.hrms.entities.concretes.Workplace;

@Service
public class WorkplaceManager implements WorkplaceService{

	private WorkplaceDao workplaceDao;

	@Autowired
	public WorkplaceManager(WorkplaceDao workplaceDao) {
		this.workplaceDao = workplaceDao;
	}

	@Override
	public DataResult<List<Workplace>> getAll() {
		List<Workplace> result = this.workplaceDao.findAll();
		return new SuccessDataResult<List<Workplace>>(result);
	}

	@Override
	public Result add(Workplace workplace) {
		this.workplaceDao.save(workplace);
		return new SuccessResult();
	}

}
