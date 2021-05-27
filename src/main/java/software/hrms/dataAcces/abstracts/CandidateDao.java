package software.hrms.dataAcces.abstracts;

import java.util.Optional;

import software.hrms.entities.concretes.Candidate;

public interface CandidateDao extends UserDao<Candidate> {
	
	Optional<Candidate> findByNationalIdentity(String nationalIdentity);

}
