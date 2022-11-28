package kodlama.io.bootcampProject.business.requests.users.employees;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import kodlama.io.bootcampProject.business.constants.Regexes;
import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

	@NotBlank(message = ValidationMessages.User.FirstNameBlank)
	@Size(min = 2, max = 30, message = ValidationMessages.User.FirstNameValid)
	private String firstName;

	@NotBlank(message = ValidationMessages.User.LastNameBlank)
	@Size(min = 2, max = 30, message = ValidationMessages.User.LastNameValid)
	private String lastName;

	@NotBlank(message = ValidationMessages.User.EmailBlank)
	@Email(regexp = Regexes.Email, message = ValidationMessages.User.EmailValid)
	private String email;

	@NotBlank(message = ValidationMessages.User.PasswordBlank)
	private String password;

	@NotBlank(message = ValidationMessages.Employee.PositionBlank)
	@Size(min = 2, max = 25, message = ValidationMessages.Employee.PositionValid)
	private String position;

	@NotBlank(message = ValidationMessages.User.NationalIdentityBlank)
	@Size(min = 11, max = 11, message = ValidationMessages.User.NationalIdentityValid)
	private String identityNo;

}
