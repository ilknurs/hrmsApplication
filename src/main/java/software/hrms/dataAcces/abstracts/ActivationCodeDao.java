package software.hrms.dataAcces.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer> {
	
	Optional<ActivationCode> findByUserId(Integer userId);
}