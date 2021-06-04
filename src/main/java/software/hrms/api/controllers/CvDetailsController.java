package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.CvDetailService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CvDetail;

@RestController
@RequestMapping(name = "/api/cvDetails")
public class CvDetailsController {

	private CvDetailService cvDetailService;

	@Autowired
	public CvDetailsController(CvDetailService cvDetailService) {
		this.cvDetailService = cvDetailService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CvDetail>> getAll() {
		return this.cvDetailService.getAll();
	}

	@GetMapping("/getByCandidate_id")
	public DataResult<CvDetail> getByCandiate_id(@RequestParam int candidate) {
		return this.cvDetailService.getByCandidate_id(candidate);
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvDetail cvDetail) {
		return this.cvDetailService.add(cvDetail);
	}

}
