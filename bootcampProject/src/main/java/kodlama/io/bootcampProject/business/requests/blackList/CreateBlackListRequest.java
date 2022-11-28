package kodlama.io.bootcampProject.business.requests.blackList;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlackListRequest {
	
	@Min(value = 1, message = ValidationMessages.Blacklist.ApplicantIdBlank)
	private int applicantId;

	@NotBlank(message = ValidationMessages.Blacklist.ReasonBlank)
	@Size(min = 5, max = 50, message = ValidationMessages.Blacklist.ReasonValid)
	private String reason;

}