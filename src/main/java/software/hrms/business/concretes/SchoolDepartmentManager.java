package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.SchoolDepartmentService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.SchoolDepartmentDao;
import software.hrms.entities.concretes.SchoolDepartment;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {

	private SchoolDepartmentDao schoolDepartmentDao;
	
	@Autowired
	public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
		this.schoolDepartmentDao = schoolDepartmentDao;
	}

	@Override
	public DataResult<List<SchoolDepartment>> getAll() {
		List<SchoolDepartment> result = this.schoolDepartmentDao.findAll();
		return new SuccessDataResult<List<SchoolDepartment>>(result);
	}

	@Override
	public Result add(SchoolDepartment schoolDepartment) {
		this.schoolDepartmentDao.save(schoolDepartment);
		return new SuccessResult();
	}

}