package kodlama.io.bootcampProject.business.requests.users.employees;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
public class UpdateEmployeeRequest {
	
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
	
	
	@NotBlank(message = ValidationMessages.Employee.PositionBlank)
	@Size(min = 2, max = 25, message = ValidationMessages.Employee.PositionValid)
	private String position;
	
	@NotBlank(message =ValidationMessages.User.NationalIdentityBlank)
	@Size(min = 11, max = 11, message = ValidationMessages.User.NationalIdentityValid)
	private String identityNo;
	
}
