package kodlama.io.bootcampProject.business.requests.bootcamps;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import kodlama.io.bootcampProject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBootcampRequest {

	@NotBlank(message = ValidationMessages.Bootcamp.InstructorIdBlank)
	private int instructorId;

	@NotBlank(message = ValidationMessages.Bootcamp.NameBlank)
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String dateStart;

	@NotBlank(message = ValidationMessages.Bootcamp.EndDateBlank)
	@JsonFormat(pattern = "dd-MM-YYYY")
	private String dateEnd;

	@NotBlank(message = ValidationMessages.Bootcamp.StateBlank)
	private int state;

}
