package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.LinkType;

public interface LinkTypeService {
	
	DataResult<List<LinkType>> getAll();

	Result add(LinkType linkType);

}
