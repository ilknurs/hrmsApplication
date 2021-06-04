package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{

}
