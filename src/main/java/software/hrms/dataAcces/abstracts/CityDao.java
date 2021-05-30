package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
}