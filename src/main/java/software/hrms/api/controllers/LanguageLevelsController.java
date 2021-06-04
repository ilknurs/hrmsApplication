package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.LanguageLevelService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.LanguageLevel;

@RestController
@RequestMapping("/api/languageLevels")
public class LanguageLevelsController {
	
	private LanguageLevelService languageLevelService;

	@Autowired
	public LanguageLevelsController(LanguageLevelService languageLevelService) {
		this.languageLevelService = languageLevelService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<LanguageLevel>> getAll() {
		return this.languageLevelService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody LanguageLevel languageLevel) {
		return this.languageLevelService.add(languageLevel);
	}


}
