package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.CandidateSchoolDepartmentService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidateSchoolDepartment;

@RestController
@RequestMapping("/api/candidateSchoolDepartments")
public class CandidateSchoolDepartmentsController {
	
	private CandidateSchoolDepartmentService candidateSchoolDepartmentService;

	@Autowired
	public CandidateSchoolDepartmentsController(CandidateSchoolDepartmentService candidateSchoolDepartmentService) {
		this.candidateSchoolDepartmentService = candidateSchoolDepartmentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSchoolDepartment>> getAll() {
		return this.candidateSchoolDepartmentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSchoolDepartment candidateSchoolDepartment) {
		return this.candidateSchoolDepartmentService.add(candidateSchoolDepartment);
	}
	
	@GetMapping("/getByCandidate_candidateIdOrderByDateOfGraduationDesc")
	public DataResult<List<CandidateSchoolDepartment>> getByCandidate_candidateIdOrderByDateOfGraduationDesc(
			@RequestParam int candidateId) {
		return this.candidateSchoolDepartmentService.getByCandidate_candidateIdOrderByDateOfGraduationDesc(candidateId);
	}
	

}
