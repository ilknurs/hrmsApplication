package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer>{

}
