package software.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer>{

}
