package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.DepartmentService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.DepartmentDao;
import software.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {
	private DepartmentDao departmentDao;

	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		List<Department> result = this.departmentDao.findAll();
		return new SuccessDataResult<List<Department>>(result);
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult();
	}

}
