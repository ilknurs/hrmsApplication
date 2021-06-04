package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.CvDetail;

public interface CvDetailDao extends JpaRepository<CvDetail, Integer> {

	CvDetail getByCandidate_id(int candidate);
}
