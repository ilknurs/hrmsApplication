package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.LanguageLevel;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel, Integer>{

}
