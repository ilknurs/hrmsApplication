package software.hrms.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer> {

	List<CandidateLanguage> getByCandidate_id(int candidateId);
}
