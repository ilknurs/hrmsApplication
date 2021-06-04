package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.CandidateWorkplaceJobPositionService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.CandidateWorkplaceJobPositionDao;
import software.hrms.entities.concretes.CandidateWorkplaceJobPosition;

@Service
public class CandidateWorkplaceJobPositionManager implements CandidateWorkplaceJobPositionService{

	private CandidateWorkplaceJobPositionDao candidateWorkplaceJobPositionDao;
	
	@Autowired
	public CandidateWorkplaceJobPositionManager(CandidateWorkplaceJobPositionDao candidateWorkplaceJobPositionDao) {
		this.candidateWorkplaceJobPositionDao = candidateWorkplaceJobPositionDao;
	}

	@Override
	public DataResult<List<CandidateWorkplaceJobPosition>> getAll() {
		List<CandidateWorkplaceJobPosition> result = this.candidateWorkplaceJobPositionDao.findAll();
		return new SuccessDataResult<List<CandidateWorkplaceJobPosition>>(result);
	}

	@Override
	public DataResult<List<CandidateWorkplaceJobPosition>> getByCandidate_id(int candidateId) {
		List<CandidateWorkplaceJobPosition> result = this.candidateWorkplaceJobPositionDao.getByCandidate_id(candidateId);
		return new SuccessDataResult<List<CandidateWorkplaceJobPosition>>(result);
	}

	@Override
	public Result add(CandidateWorkplaceJobPosition candidateWorkplaceJobPosition) {
		this.candidateWorkplaceJobPositionDao.save(candidateWorkplaceJobPosition);
		return new SuccessResult();
	}

}
