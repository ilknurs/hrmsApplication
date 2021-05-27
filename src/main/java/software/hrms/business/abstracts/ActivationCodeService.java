package software.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {
	
	DataResult<List<ActivationCode>> getAll();

	Result add(ActivationCode activationCode);

	Result update(ActivationCode activationCode);
	
	DataResult <Optional<ActivationCode>> getByUserId(int userId);
}