package software.hrms.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.CandidateSchoolDepartment;

public interface CandidateSchoolDepartmentDao extends JpaRepository<CandidateSchoolDepartment, Integer>{
	List<CandidateSchoolDepartment> getByCandidate_idOrderByDateOfGraduationDesc(
			int candidateId);

}
