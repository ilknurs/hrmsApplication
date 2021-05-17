package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();

}
