package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.WorkplaceService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Workplace;

@RestController
@RequestMapping("/api/workplaces")
public class WorkplacesController {

	private WorkplaceService workplaceService;

	@Autowired
	public WorkplacesController(WorkplaceService workplaceService) {
		this.workplaceService = workplaceService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Workplace>> getAll() {
		return this.workplaceService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Workplace workplace) {
		return this.workplaceService.add(workplace);
	}

}
