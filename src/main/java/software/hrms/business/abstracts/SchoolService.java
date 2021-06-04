package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.School;

public interface SchoolService {
	
	DataResult<List<School>> getAll();
	
	Result add(School school);
}
