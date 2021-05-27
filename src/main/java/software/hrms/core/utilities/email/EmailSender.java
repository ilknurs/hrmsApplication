package software.hrms.core.utilities.email;

import org.springframework.stereotype.Component;

@Component
public class EmailSender implements EmailSenderService {

	@Override
	public void send(String body) {
		System.out.println(body);

	}

}
