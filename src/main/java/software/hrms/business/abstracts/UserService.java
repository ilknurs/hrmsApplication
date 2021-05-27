package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.abstracts.User;



public interface UserService<T extends User> {
	DataResult<List<T>>getAll();
    Result add(T t);

}
