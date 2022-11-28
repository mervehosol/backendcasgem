package kodlama.io.bootcampProject.business.responses.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicationResponse {
	private int id;
	private int applicantId;
	private int bootcampId;

	private int state;
}
