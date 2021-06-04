package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Ability;

public interface AbilityService {
	
	DataResult<List<Ability>> getAll();
	Result add(Ability ability);
	

}
