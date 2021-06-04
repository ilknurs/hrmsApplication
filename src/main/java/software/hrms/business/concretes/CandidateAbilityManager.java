package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.CandidateAbilityService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.CandidateAbilityDao;
import software.hrms.entities.concretes.CandidateAbility;

@Service
public class CandidateAbilityManager implements CandidateAbilityService{

	private CandidateAbilityDao candidateAbilityDao;
	
	
	@Autowired
	public CandidateAbilityManager(CandidateAbilityDao candidateAbilityDao) {
		this.candidateAbilityDao = candidateAbilityDao;
	}

	@Override
	public DataResult<List<CandidateAbility>> getAll() {
		List<CandidateAbility> result = this.candidateAbilityDao.findAll();
		return new SuccessDataResult<List<CandidateAbility>>(result);
	}

	@Override
	public DataResult<List<CandidateAbility>> getByCandidate_id(int candidateId) {
		List<CandidateAbility> result = this.candidateAbilityDao.getByCandidate_id(candidateId);
		return new SuccessDataResult<List<CandidateAbility>>(result);
	}

	@Override
	public Result add(CandidateAbility candidateAbility) {
		this.candidateAbilityDao.save(candidateAbility);
		return new SuccessResult();
	}

}
