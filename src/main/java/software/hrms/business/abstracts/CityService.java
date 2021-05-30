package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.City;


public interface CityService {
	
	DataResult<List<City>> getAll();

	Result add(City city);

}
