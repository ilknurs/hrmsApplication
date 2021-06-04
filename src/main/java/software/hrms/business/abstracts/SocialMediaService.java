package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	
	DataResult<List<SocialMedia>> getAll();
	
	DataResult<List<SocialMedia>> getByCandidate_id(int candidateId);
	
	Result add(SocialMedia socialMedia);

}
