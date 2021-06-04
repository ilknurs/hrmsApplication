package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.LinkType;

public interface LinkTypeDao extends JpaRepository<LinkType, Integer>{

}
