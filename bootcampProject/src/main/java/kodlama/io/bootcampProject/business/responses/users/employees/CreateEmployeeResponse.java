package kodlama.io.bootcampProject.business.responses.users.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeResponse {
	private int userId;
    
	private String position;
}
