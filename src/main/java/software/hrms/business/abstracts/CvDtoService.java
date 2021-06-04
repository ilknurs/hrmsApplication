package software.hrms.business.abstracts;

import software.hrms.core.utilities.results.Result;
import software.hrms.entities.dtos.CvDto;

public interface CvDtoService {

	Result add(CvDto cvDto);

}
