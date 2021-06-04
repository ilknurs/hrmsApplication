package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Language;

public interface LanguageService {
	
	DataResult<List<Language>> getAll();
	
	Result add(Language language);

}
