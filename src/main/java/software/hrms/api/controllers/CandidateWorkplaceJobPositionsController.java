package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.CandidateWorkplaceJobPositionService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidateWorkplaceJobPosition;

@RestController
@RequestMapping("/api/candidateWorkplaceJobPositions")
public class CandidateWorkplaceJobPositionsController {

	private CandidateWorkplaceJobPositionService candidateWorkplaceJobPositionService;

	@Autowired
	public CandidateWorkplaceJobPositionsController(
			CandidateWorkplaceJobPositionService candidateWorkplaceJobPositionService) {
		this.candidateWorkplaceJobPositionService = candidateWorkplaceJobPositionService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateWorkplaceJobPosition>> getAll() {
		return this.candidateWorkplaceJobPositionService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<List<CandidateWorkplaceJobPosition>> getByCandidate_id(@RequestParam int candidateId) {
		return this.candidateWorkplaceJobPositionService.getByCandidate_id(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateWorkplaceJobPosition candidateWorkplaceJobPosition) {
		return this.candidateWorkplaceJobPositionService.add(candidateWorkplaceJobPosition);
	}

	
	
	
	
	
	
	
}
