package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.LanguageLevel;

public interface LanguageLevelService {
	
	DataResult<List<LanguageLevel>> getAll();
	
	Result add(LanguageLevel languageLevel);
}
