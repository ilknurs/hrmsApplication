package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.CandidateLanguageService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/candidateLanguages")
public class CandidateLanguagesController {

	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateLanguage>> getAll() {
		return this.candidateLanguageService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<List<CandidateLanguage>> getByCandidate_id(@RequestParam int candidateId) {
		return this.candidateLanguageService.getByCandidate_id(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguage candidateLanguage) {
		return this.candidateLanguageService.add(candidateLanguage);
	}
	
}
