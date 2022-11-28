package kodlama.io.bootcampProject.business.requests.applications;

import javax.validation.constraints.NotBlank;

import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicationRequest {
	@NotBlank(message = ValidationMessages.Application.ApplicantIdBlank)
	private int applicantId;
	
	@NotBlank(message = ValidationMessages.Application.BootcampIdBlank)
	private int bootcampId;
	
	@NotBlank(message= ValidationMessages.Application.StateBlank )
	private int state;
	
}
