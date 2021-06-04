package software.hrms.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.CandidateWorkplaceJobPosition;

public interface CandidateWorkplaceJobPositionDao extends JpaRepository<CandidateWorkplaceJobPosition, Integer>{
	
	List<CandidateWorkplaceJobPosition> getByCandidate_id(int candidateId);

}
