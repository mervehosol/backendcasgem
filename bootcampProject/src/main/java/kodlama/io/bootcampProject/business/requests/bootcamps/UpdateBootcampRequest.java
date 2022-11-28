package kodlama.io.bootcampProject.business.requests.bootcamps;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {

	private int id;
	private int instructorId;

	@NotBlank(message = ValidationMessages.Bootcamp.NameBlank)
	@Size(min = 3, max = 50, message = ValidationMessages.Bootcamp.NameValid)
	private String name;

	@NotNull(message = ValidationMessages.Bootcamp.StartDateBlank)
	private LocalDate startDate;
	
	@NotNull(message = ValidationMessages.Bootcamp.EndDateBlank)
	private LocalDate endDate;
	
	@NotBlank(message = ValidationMessages.Bootcamp.StateBlank)
	private int state;

}
