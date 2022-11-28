package kodlama.io.bootcampProject.business.requests.users.applicants;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import kodlama.io.bootcampProject.business.constants.Regexes;
import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {
	
	@NotBlank(message = ValidationMessages.User.IdBlank)
	private int userId;
	
	@NotBlank(message =ValidationMessages.User.FirstNameBlank)
	@Size(min =2, max=30, message =ValidationMessages.User.FirstNameValid)
	private String firstName;

	@NotBlank(message =ValidationMessages.User.LastNameBlank)
	@Size(min =2, max=30, message =ValidationMessages.User.LastNameValid)
	private String lastName;

	@NotBlank(message =ValidationMessages.User.EmailBlank)
	@Email(regexp = Regexes.Email, message = ValidationMessages.User.EmailValid)
	private String email;
	
	
	@NotBlank(message =ValidationMessages.User.PasswordBlank)
	private String password;
	
	@NotBlank(message =ValidationMessages.Applicant.AboutBlank)
	@Length(min = 5, max = 100, message = ValidationMessages.Applicant.AboutValid)
	private String about;
	
}
	
	
