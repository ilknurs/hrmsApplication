package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidateSchoolDepartment;

public interface CandidateSchoolDepartmentService {
	
	DataResult<List<CandidateSchoolDepartment>> getAll();
	
	Result add(CandidateSchoolDepartment candidateSchoolDepartment);
	
	DataResult<List<CandidateSchoolDepartment>> getByCandidate_candidateIdOrderByDateOfGraduationDesc(int candidateId);
}



