package software.hrms.business.concretes;

import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.CandidateAbilityService;
import software.hrms.business.abstracts.CandidateLanguageService;
import software.hrms.business.abstracts.CandidateSchoolDepartmentService;
import software.hrms.business.abstracts.CandidateService;
import software.hrms.business.abstracts.CandidateWorkplaceJobPositionService;
import software.hrms.business.abstracts.CvDtoService;
import software.hrms.business.abstracts.SocialMediaService;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.dtos.CvDto;

@Service
public class CvDtoManager implements CvDtoService {

	private CandidateWorkplaceJobPositionService candidateWorkplaceJobPositionService;
	private CandidateSchoolDepartmentService candidateSchoolDepartmentService;
	private CandidateLanguageService candidateLAnguageService;
	private CandidateAbilityService CandidateAbilityService;
	private SocialMediaService socailMediaService;
	private CandidateService candidateService;

	public CvDtoManager(CandidateWorkplaceJobPositionService candidateWorkplaceJobPositionService,
			CandidateSchoolDepartmentService candidateSchoolDepartmentService,
			CandidateLanguageService candidateLAnguageService,
			software.hrms.business.abstracts.CandidateAbilityService candidateAbilityService,
			SocialMediaService socailMediaService, CandidateService candidateService) {
		this.candidateWorkplaceJobPositionService = candidateWorkplaceJobPositionService;
		this.candidateSchoolDepartmentService = candidateSchoolDepartmentService;
		this.candidateLAnguageService = candidateLAnguageService;
		CandidateAbilityService = candidateAbilityService;
		this.socailMediaService = socailMediaService;
		this.candidateService = candidateService;
	}

	@Override
	public Result add(CvDto cvDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
