package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.CodeGenerator;
import software.hrms.business.abstracts.JobPositionService;
import software.hrms.business.constant.Messages;
import software.hrms.core.utilities.business.BusinessEngine;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.ErrorResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.JobPositionDao;
import software.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao  jobPositionDao;


    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

	@Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(),Messages.jobPositionListed);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        Result result = BusinessEngine.run(isJobPositionExist(jobPosition));
        if(result.isSuccess()){
           
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.jobPositionAdded);
        }
        return result;
    }


    private Result isJobPositionExist(JobPosition jobPosition){
        if(jobPositionDao.findByTitle(jobPosition.getTitle()).isPresent()){
            return new ErrorResult(Messages.jobTitleExist);
        }
        return new SuccessResult();
    }

	
}
