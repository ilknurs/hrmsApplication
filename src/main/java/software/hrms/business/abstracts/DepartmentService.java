package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Department;

public interface DepartmentService {

	DataResult<List<Department>> getAll();

	Result add(Department department);

}
