package kodlama.io.bootcampProject.business.concretes.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import kodlama.io.bootcampProject.business.constants.Messages;

import kodlama.io.bootcampProject.business.abstracts.users.EmployeeService;
import kodlama.io.bootcampProject.business.requests.users.employees.CreateEmployeeRequest;
import kodlama.io.bootcampProject.business.requests.users.employees.UpdateEmployeeRequest;
import kodlama.io.bootcampProject.business.responses.users.employees.CreateEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.GetAllEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.GetEmployeeResponse;
import kodlama.io.bootcampProject.business.responses.users.employees.UpdateEmployeeResponse;
import kodlama.io.bootcampProject.core.utilities.exceptions.BusinessException;
import kodlama.io.bootcampProject.core.utilities.mapping.ModelMapperService;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import kodlama.io.bootcampProject.core.utilities.results.SuccessDataResult;
import kodlama.io.bootcampProject.core.utilities.results.SuccessResult;
import kodlama.io.bootcampProject.dataAccess.abstracts.users.EmployeeRepository;
import kodlama.io.bootcampProject.entities.users.Employee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;

	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		checkIfEmployeeByIdentityNo(createEmployeeRequest.getIdentityNo());
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				CreateEmployeeResponse.class);
		return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse, Messages.EmployeeCreated);
	}

	private void checkIfEmployeeByIdentityNo(String identityNo) {
		Employee currEmployee = this.employeeRepository.findByIdentityNo(identityNo);
		if (currEmployee != null) {
			throw new BusinessException(Messages.EmployeeExist);
		}
	}

	
	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfEmployeeByIdentityNo(updateEmployeeRequest.getIdentityNo());
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		
		this.employeeRepository.save(employee);
		UpdateEmployeeResponse response = this.modelMapperService.forResponse().map(employee,
				UpdateEmployeeResponse.class);
		return new SuccessDataResult<UpdateEmployeeResponse>(response, Messages.EmployeeUpdated);
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		Employee employee = this.employeeRepository.findById(id).get();

		GetEmployeeResponse response = this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);

		return new SuccessDataResult<GetEmployeeResponse>(response);
	}

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		List<Employee> employees = this.employeeRepository.findAll();
		List<GetAllEmployeeResponse> response = employees.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(response);
	}

	@Override
	public Result delete(int id) {
		checkIfInstructorById(id);
		this.employeeRepository.deleteById(id);
		return new SuccessResult(Messages.EmployeeDeleted);
	}

	private void checkIfInstructorById(int id) {
		if(!this.employeeRepository.existsById(id)){
			throw new BusinessException(Messages.EmployeeIdNotExist);
		}
		
	}
}
