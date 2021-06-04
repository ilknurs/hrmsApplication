package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import software.hrms.business.abstracts.CandidatePhotoService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Candidate;
import software.hrms.entities.concretes.CandidatePhoto;

@RestController
@RequestMapping("/api/candidatePhotos")
public class CandidatePhotosController {

	private CandidatePhotoService candidatePhotoService;

	@Autowired
	public CandidatePhotosController(CandidatePhotoService candidatePhotoService) {
		this.candidatePhotoService = candidatePhotoService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CandidatePhoto>> getAll() {
		return this.candidatePhotoService.getAll();
	}

	@GetMapping("/getByCandidate_id")
	public DataResult<CandidatePhoto> getByJobSeeker_id(int jobSeekerId) {
		return this.candidatePhotoService.getByCandidate_id(jobSeekerId);
	}

	@PostMapping("/add")
	public Result add(@RequestParam int candidateId, @RequestParam MultipartFile file) {

		CandidatePhoto jobSeekerPhoto = new CandidatePhoto();
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		jobSeekerPhoto.setCandidate(candidate);

		return this.candidatePhotoService.add(jobSeekerPhoto, file);
	}

}
