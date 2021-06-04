package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.LanguageService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.LanguageDao;
import software.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		List<Language> result = this.languageDao.findAll();
		return new SuccessDataResult<List<Language>>(result);
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult();
	}

}