package kodlama.io.bootcampProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.bootcampProject.business.abstracts.users.EmployeeService;
import kodlama.io.bootcampProject.business.requests.users.employees.CreateEmployeeRequest;
import kodlama.io.bootcampProject.business.requests.users.employees.UpdateEmployeeRequest;
import kodlama.io.bootcampProject.business.responses.users.employees.CreateEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.GetAllEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.GetEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.UpdateEmployeeResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int id) {
		return this.employeeService.getById(id);
	}
	@GetMapping()
	public DataResult<List<GetAllEmployeeResponse>> getAll(){
		return this.employeeService.getAll();
	}
	@PostMapping()
    public DataResult<CreateEmployeeResponse> create(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest){
         return this.employeeService.add(createEmployeeRequest);
     }
	
	@PutMapping()
    public  DataResult<UpdateEmployeeResponse> update (@Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
         return this.employeeService.update(updateEmployeeRequest);
     }
	 @DeleteMapping("/{id}")
	    public Result delete (@PathVariable int id){
	         return this.employeeService.delete(id);
	     }
}
