package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}
