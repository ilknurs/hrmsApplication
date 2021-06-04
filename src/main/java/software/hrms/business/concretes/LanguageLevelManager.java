package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.LanguageLevelService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.LanguageLevelDao;
import software.hrms.entities.concretes.LanguageLevel;

@Service
public class LanguageLevelManager implements LanguageLevelService {

	private LanguageLevelDao languageLevelDao;
	
	@Autowired
	public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
		this.languageLevelDao = languageLevelDao;
	}

	@Override
	public DataResult<List<LanguageLevel>> getAll() {
		List<LanguageLevel> result = this.languageLevelDao.findAll();
		return new SuccessDataResult<List<LanguageLevel>>(result);
	}

	@Override
	public Result add(LanguageLevel languageLevel) {
		this.languageLevelDao.save(languageLevel);
		return new SuccessResult();
	}
	
}
