package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.CvDetailService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.CvDetailDao;
import software.hrms.entities.concretes.CvDetail;

@Service
public class CvDetailManager implements CvDetailService{
	
	private CvDetailDao cvDetailDao;

	
	@Autowired
	public CvDetailManager(CvDetailDao cvDetailDao) {
		this.cvDetailDao = cvDetailDao;
	}

	@Override
	public DataResult<List<CvDetail>> getAll() {
		List<CvDetail> result = this.cvDetailDao.findAll();
		return new SuccessDataResult<List<CvDetail>>(result);
	}

	@Override
	public DataResult<CvDetail> getByCandidate_id(int candidate) {
		CvDetail result = this.cvDetailDao.getByCandidate_id(candidate);
		return new SuccessDataResult<CvDetail>(result);
	}

	@Override
	public Result add(CvDetail cvDetail) {
		this.cvDetailDao.save(cvDetail);
		return new SuccessResult();
	}
	
	
	
	
	
	
	
	

}
