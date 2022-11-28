package kodlama.io.bootcampProject.business.responses.bootcamps;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBootcampResponse {
	private int id;
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private int  instructorId;
	private int state;
}
