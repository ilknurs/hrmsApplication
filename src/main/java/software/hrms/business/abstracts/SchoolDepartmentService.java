package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentService {

	DataResult<List<SchoolDepartment>> getAll();

	Result add(SchoolDepartment schoolDepartment);

}
