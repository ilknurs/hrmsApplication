package software.hrms.entities.dtos;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForCandidateDto {
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private Date dateOfBirth;
	private String email;
	private String password;
	private String confirmPassword;
}