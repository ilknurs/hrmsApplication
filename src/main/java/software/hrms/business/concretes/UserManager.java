package software.hrms.business.concretes;

import software.hrms.business.abstracts.UserService;
import software.hrms.business.constant.Messages;
import software.hrms.core.dataAccess.UserDao;
import software.hrms.core.entities.User;
import software.hrms.core.utilities.results.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager<T extends User> implements UserService<T> {
	private  UserDao<T> userDao;

	@Autowired
	public UserManager(UserDao<T> userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<T>> getAll() {
		return new SuccessDataResult<List<T>>(this.userDao.findAll(), Messages.userListed);
	}

	@Override
	public Result add(T t) {
		this.userDao.save(t);
		return new SuccessResult(Messages.userAdded);
	}

	public Result isEmailExist(String email) {
		if (userDao.findByEmail(email).isPresent()) {
			return new ErrorResult(Messages.emailExist);
		}
		return new SuccessResult();
	}
}