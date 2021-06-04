package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.SchoolService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.SchoolDao;
import software.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		List<School> result = this.schoolDao.findAll();
		return new SuccessDataResult<List<School>>(result);
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult();
	}

}