package kodlama.io.bootcampProject.business.responses.bootcamps;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBootcampResponse {
	private int id;
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private int  instructorId;
	private int state;
}
