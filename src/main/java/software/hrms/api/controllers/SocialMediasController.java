package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.SocialMediaService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialMedias")
public class SocialMediasController {

	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		this.socialMediaService = socialMediaService;
	}

	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll() {
		return this.socialMediaService.getAll();
	}

	@GetMapping("/getByJobSeeker_id")
	public DataResult<List<SocialMedia>> getByCandidate_id(@RequestParam int candidateId) {
		return this.socialMediaService.getByCandidate_id(candidateId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.add(socialMedia);
	}

}
