package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.SocialMediaService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.SocialMediaDao;
import software.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		this.socialMediaDao = socialMediaDao;
	}


	@Override
	public DataResult<List<SocialMedia>> getAll() {
		List<SocialMedia> result = this.socialMediaDao.findAll();
		return new SuccessDataResult<List<SocialMedia>>(result);
	}

	@Override
	public DataResult<List<SocialMedia>> getByCandidate_id(int candidateId) {
		List<SocialMedia> result = this.socialMediaDao.getByCandidate_id(candidateId);
		return new SuccessDataResult<List<SocialMedia>>(result);
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult();
	}

}