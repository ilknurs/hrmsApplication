package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.LinkTypeService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAcces.abstracts.LinkTypeDao;
import software.hrms.entities.concretes.LinkType;

@Service
public class LinkTypeManager implements LinkTypeService {

	private LinkTypeDao linkTypeDao;
	
	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao) {
		this.linkTypeDao = linkTypeDao;
	}

	@Override
	public DataResult<List<LinkType>> getAll() {
		List<LinkType> result = this.linkTypeDao.findAll();
		return new SuccessDataResult<List<LinkType>>(result);
	}

	@Override
	public Result add(LinkType linkType) {
		this.linkTypeDao.save(linkType);
		return new SuccessResult();
	}

}