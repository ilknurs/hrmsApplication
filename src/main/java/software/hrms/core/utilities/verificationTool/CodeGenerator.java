package software.hrms.core.utilities.verificationTool;

import java.util.UUID;

public class CodeGenerator {

	
	public static String generateUuidCode() {
		
		return UUID.randomUUID().toString();
	}

}
