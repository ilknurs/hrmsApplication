package software.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.CandidatePhoto;

public interface CandidatePhotoService {

	DataResult<List<CandidatePhoto>> getAll();

	DataResult<CandidatePhoto> getByCandidate_id(int candidateId);

	Result add(CandidatePhoto candidatePhoto);

	Result add(CandidatePhoto candidatePhoto, MultipartFile file);

}
