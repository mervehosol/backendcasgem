package kodlama.io.bootcampProject.business.requests.blackList;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListRequest {



	@NotNull(message = ValidationMessages.Blacklist.IdBlank)
	private int id;
	
	@NotNull(message = ValidationMessages.Blacklist.ApplicantIdBlank)
	private int applicantId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	@NotNull(message = ValidationMessages.Blacklist.ReasonBlank )
	private String reason;
}
