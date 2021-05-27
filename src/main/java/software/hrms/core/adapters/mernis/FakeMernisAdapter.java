package software.hrms.core.adapters.mernis;

import org.springframework.stereotype.Component;

import software.hrms.core.adapters.models.MernisPerson;

@Component //@Bean. Service ile aynı işi görüyor. Autowired ile çalışıyor
public class FakeMernisAdapter implements UserRealCheckService {

	@Override
	public boolean validate(MernisPerson person) {
		
		return true;
	}

}
