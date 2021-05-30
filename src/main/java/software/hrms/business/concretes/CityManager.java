package software.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Component;

import software.hrms.business.abstracts.CityService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.CityDao;
import software.hrms.entities.concretes.City;

@Component
public class CityManager implements CityService {
 
	private CityDao cityDao;

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<City>> getAll() {
		List<City> result = this.cityDao.findAll();
		return new SuccessDataResult<List<City>>(result);
	}

}
