package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Employer;
 
public interface EmployerService extends UserService<Employer> {

	DataResult<List<Employer>> getAll();

	Result add(Employer jobPosition);

}
