package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.CandidatePhoto;

public interface CandidatePhotoDao extends JpaRepository<CandidatePhoto, Integer>{

	CandidatePhoto getByCandidate_id(int candidateId);
}
