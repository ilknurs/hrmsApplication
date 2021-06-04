package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.CandidateAbilityService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidateAbility;

@RestController
@RequestMapping("/api/candidateAbilities")
public class CandidateAbilitiesController {
	
	private CandidateAbilityService candidateAbilityService;

	@Autowired
	public CandidateAbilitiesController(CandidateAbilityService candidateAbilityService) {
		this.candidateAbilityService = candidateAbilityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateAbility>> getAll() {
		return this.candidateAbilityService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<List<CandidateAbility>> getByCandidate_id(@RequestBody int candidateId) {
		return this.candidateAbilityService.getByCandidate_id(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateAbility candidateAbility) {
		return this.candidateAbilityService.add(candidateAbility);
	}

	
}
