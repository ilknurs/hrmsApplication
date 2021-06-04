package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

}
