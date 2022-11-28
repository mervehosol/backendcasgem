package kodlama.io.bootcampProject.business.abstracts.users;

import java.util.List;



import kodlama.io.bootcampProject.business.requests.users.employees.CreateEmployeeRequest;
import kodlama.io.bootcampProject.business.requests.users.employees.UpdateEmployeeRequest;
import kodlama.io.bootcampProject.business.responses.users.employees.CreateEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.GetAllEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.GetEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.UpdateEmployeeResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;

public interface EmployeeService {

	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);
	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
	DataResult<GetEmployeeResponse> getById(int id);
	DataResult<List<GetAllEmployeeResponse>> getAll();
	Result delete(int id);
	
	
	
}
