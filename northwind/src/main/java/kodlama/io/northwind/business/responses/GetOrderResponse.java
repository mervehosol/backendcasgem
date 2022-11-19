package kodlama.io.northwind.business.responses;

import java.time.LocalDateTime;

import kodlama.io.northwind.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
	
	private  int id;
	private LocalDateTime date;
	private int employeeId;
}
