package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.CandidateSchoolDepartmentService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.CandidateSchoolDepartmentDao;
import software.hrms.entities.concretes.CandidateSchoolDepartment;

@Service
public class CandidateSchoolDepartmentManager implements CandidateSchoolDepartmentService{

	private CandidateSchoolDepartmentDao candidateSchoolDepartmentDao;
	

	@Autowired
	public CandidateSchoolDepartmentManager(CandidateSchoolDepartmentDao candidateSchoolDepartmentDao) {
		this.candidateSchoolDepartmentDao = candidateSchoolDepartmentDao;
	}

	@Override
	public DataResult<List<CandidateSchoolDepartment>> getAll() {
		List<CandidateSchoolDepartment> result = this.candidateSchoolDepartmentDao.findAll();
		return new SuccessDataResult<List<CandidateSchoolDepartment>>(result);
	}

	@Override
	public Result add(CandidateSchoolDepartment candidateSchoolDepartment) {
		this.candidateSchoolDepartmentDao.save(candidateSchoolDepartment);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateSchoolDepartment>> getByCandidate_candidateIdOrderByDateOfGraduationDesc(
			int candidateId) {
		List<CandidateSchoolDepartment> result = this.candidateSchoolDepartmentDao
				.getByCandidate_idOrderByDateOfGraduationDesc(candidateId);
		return new SuccessDataResult<List<CandidateSchoolDepartment>>(result);
	}

}
