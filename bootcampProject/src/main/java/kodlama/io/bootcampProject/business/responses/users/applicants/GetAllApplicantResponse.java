package kodlama.io.bootcampProject.business.responses.users.applicants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllApplicantResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
}
