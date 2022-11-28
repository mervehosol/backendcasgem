package kodlama.io.bootcampProject.business.responses.users.instructors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	private String companyName;
}
