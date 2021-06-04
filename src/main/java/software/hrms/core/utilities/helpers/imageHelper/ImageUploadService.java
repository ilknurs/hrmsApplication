package software.hrms.core.utilities.helpers.imageHelper;

import org.springframework.web.multipart.MultipartFile;

import software.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	
	DataResult<?> save(MultipartFile image);

}
