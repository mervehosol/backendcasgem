package kodlama.io.bootcampProject.business.requests.users.instructors;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import kodlama.io.bootcampProject.business.constants.Regexes;
import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInstructorRequest {

	private int id;

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

	@NotEmpty(message = "CompanyName cannot be empty")
	private String companyName;

	@NotBlank(message =ValidationMessages.User.NationalIdentityBlank)
	@Size(min = 11, max = 11, message = ValidationMessages.User.NationalIdentityValid)
	private String identityNo;

	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
}
