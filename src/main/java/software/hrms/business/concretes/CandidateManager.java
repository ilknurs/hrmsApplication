package software.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.CandidateService;
import software.hrms.business.constant.Messages;
import software.hrms.business.validationRules.CandidateValidatorService;
import software.hrms.core.adapters.mernis.UserRealCheckService;
import software.hrms.core.adapters.models.MernisPerson;
import software.hrms.core.utilities.business.BusinessEngine;
import software.hrms.core.utilities.results.ErrorResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.CandidateDao;
import software.hrms.dataAcces.abstracts.UserDao;
import software.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager extends UserManager<Candidate> implements CandidateService {

    private CandidateDao candidateDao;
    private UserRealCheckService userRealCheckService;
    private CandidateValidatorService candidateValidatorService;

    @Autowired
    public CandidateManager(UserDao<Candidate> userDao, UserRealCheckService userRealCheckService,
                            CandidateValidatorService candidateValidatorService) {
        super(userDao);
        this.candidateDao = (CandidateDao) userDao; //unboxing
        this.userRealCheckService = userRealCheckService;
        this.candidateValidatorService = candidateValidatorService;
    }

    @Override
    public Result add(Candidate candidate) {
        Result validateResult = candidateValidatorService.candidateNullCheck(candidate);
        if(validateResult.isSuccess()) {
            Result result = BusinessEngine.run(super.isEmailExist(candidate.getEmail()), isIdentityNumberExist(candidate.getNationalIdentity()),
                    isMernisVerified(candidate));
            if (result.isSuccess()) {
                return super.add(candidate);
            }
            return result;
        }
        return validateResult;
    }

    private Result isIdentityNumberExist(String identityNumber) {
        if (candidateDao.findByNationalIdentity(identityNumber).isPresent()) {
            return new ErrorResult(Messages.nationalityIdentityExist);
        }
        return new SuccessResult();
    }

    private Result isMernisVerified(Candidate candidate) {
        MernisPerson mernisPerson = new MernisPerson(candidate.getFirstName(), candidate.getLastName(),
                candidate.getNationalIdentity(), candidate.getDateOfBirth());
        boolean result = userRealCheckService.validate(mernisPerson);
        if(result){
            return new SuccessResult();
        }
        return new ErrorResult(Messages.personInValid);
    }
}
