package kodlama.io.northwind.business.abstracts;

import java.util.List;

import kodlama.io.northwind.business.requests.employees.CreateEmployeeRequest;
import kodlama.io.northwind.business.responses.employees.GetAllEmployeesResponse;

public interface EmployeeService {
	List <GetAllEmployeesResponse> getAll();
	void add(CreateEmployeeRequest createEmployeeRequest );

}
