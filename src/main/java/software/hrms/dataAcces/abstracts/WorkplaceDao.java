package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.Workplace;

public interface WorkplaceDao extends JpaRepository<Workplace, Integer> {

}
