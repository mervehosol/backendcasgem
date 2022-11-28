package kodlama.io.bootcampProject.business.requests.applications;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicationRequest {

	private int id;
	
	@Min(value = 1, message = ValidationMessages.Application.BootcampIdBlank)
	private int bootcampId;
	@Min(value = 1, message = ValidationMessages.Application.ApplicantIdBlank)
	private int applicantId;
	
	@NotBlank(message = ValidationMessages.Application.StateBlank)
	private int state;


}
