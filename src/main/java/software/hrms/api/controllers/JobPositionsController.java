package software.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.JobPositionService;
import software.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")

public class JobPositionsController {

	private JobPositionService jobPositionService;

	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public List<JobPosition> getAll() {
		return jobPositionService.getAll();
	}

}
