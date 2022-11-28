package kodlama.io.bootcampProject.business.responses.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllApplicationResponse {
	private int id;
	
	private String applicantId;
	private String bootcampId;
	private int  state;
	
}
