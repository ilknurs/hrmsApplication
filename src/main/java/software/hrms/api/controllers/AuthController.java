package software.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.auth.CandidateAuthService;
import software.hrms.business.abstracts.auth.EmployerAuthService;
import software.hrms.business.abstracts.auth.VerifyService;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.dtos.RegisterForCandidateDto;
import software.hrms.entities.dtos.RegisterForEmployerDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private CandidateAuthService candidateAuthService;
    private EmployerAuthService employerAuthService;
    private VerifyService verifyService;

    @Autowired
    public AuthController(CandidateAuthService candidateAuthService, EmployerAuthService employerAuthService,VerifyService verifyService) {
        this.candidateAuthService = candidateAuthService;
        this.employerAuthService = employerAuthService;
        this.verifyService = verifyService;
    }

    @PostMapping("/candidate/register")
    public Result registerForCandidate(@RequestBody RegisterForCandidateDto registerForCandidateDto){
        return candidateAuthService.register(registerForCandidateDto);
    }

    @PostMapping("/employer/register")
    public Result registerForEmployer(@RequestBody RegisterForEmployerDto registerForEmployerDto){
        return employerAuthService.register(registerForEmployerDto);
    }

    @GetMapping("/verify")
    public Result verify(int userId, String activationCode){
        return verifyService.verify(userId,activationCode);
    }
}
