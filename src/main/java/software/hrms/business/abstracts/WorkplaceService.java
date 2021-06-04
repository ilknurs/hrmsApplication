package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Workplace;

public interface WorkplaceService {
	
	DataResult<List<Workplace>> getAll();
	
	Result add(Workplace workplace);

}
