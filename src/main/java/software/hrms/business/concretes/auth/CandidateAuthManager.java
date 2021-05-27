package software.hrms.business.concretes.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.ActivationCodeService;
import software.hrms.business.abstracts.CandidateService;
import software.hrms.business.abstracts.auth.CandidateAuthService;
import software.hrms.business.constant.Messages;
import software.hrms.business.validationRules.AuthValidatorService;
import software.hrms.core.utilities.business.BusinessEngine;
import software.hrms.core.utilities.email.EmailSenderService;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.core.utilities.verificationTool.CodeGenerator;
import software.hrms.entities.concretes.ActivationCode;
import software.hrms.entities.concretes.Candidate;
import software.hrms.entities.dtos.RegisterForCandidateDto;

@Service
public class CandidateAuthManager implements CandidateAuthService {
	private AuthValidatorService authValidatorService;
	private CandidateService candidateService;
	private ActivationCodeService activationCodeService;
	private EmailSenderService emailSenderService;

	@Autowired
	public CandidateAuthManager(AuthValidatorService authValidatorService, CandidateService candidateService) {
		this.authValidatorService = authValidatorService;
		this.candidateService = candidateService;
	}

	@Override
	public Result register(RegisterForCandidateDto registerForCandidateDto) {
		Result result = BusinessEngine.run(authValidatorService.isPasswordConfirmed(
				registerForCandidateDto.getPassword(), registerForCandidateDto.getConfirmPassword()));
		if (!result.isSuccess()) {
			return result;
		}

		// dto candidate'e maplendi.
		Candidate candidate = new Candidate(registerForCandidateDto.getFirstName(),
				registerForCandidateDto.getLastName(), registerForCandidateDto.getNationalIdentity(),
				registerForCandidateDto.getDateOfBirth(), registerForCandidateDto.getEmail(),
				registerForCandidateDto.getPassword());
		
		
		Result addResult = candidateService.add(candidate);
		if (!addResult.isSuccess()) {
			return addResult;
		}
		String code = CodeGenerator.generateUuidCode();
		ActivationCode activationCode = new ActivationCode(candidate.getId(), code);
		Result activationResult = activationCodeService.add(activationCode);

		if (activationResult.isSuccess()) {
			return activationResult;

		}

		emailSenderService.send("Doğrulama için linke tıklayınız .." + code);
		return new SuccessResult(Messages.userAdded);
	}


	
}




