package software.hrms.core.adapters.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MernisPerson {

	private String firstName;
	private String lastName;
	private String identificationNumber;
	private Date birthYear;

}
