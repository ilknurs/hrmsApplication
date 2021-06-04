package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.AbilityService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Ability;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {

	private AbilityService abilityService;

	@Autowired
	public AbilitiesController(AbilityService abilityService) {
		this.abilityService = abilityService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Ability>> getAll() {
		return this.abilityService.getAll();

	}

	@PostMapping("/add")
	public Result add(@RequestBody Ability ability) {
		return this.abilityService.add(ability);
	}

}
