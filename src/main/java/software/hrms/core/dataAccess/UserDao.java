package software.hrms.core.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.core.entities.User;

public interface UserDao<T extends User> extends JpaRepository<T, Integer> {
	
	Optional<T> findByEmail(String email);
}