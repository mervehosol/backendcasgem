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

import kodlama.io.bootcampProject.business.abstracts.users.InstructorService;
import kodlama.io.bootcampProject.business.requests.users.instructors.CreateInstructorRequest;
import kodlama.io.bootcampProject.business.requests.users.instructors.UpdateInstructorRequest;
import kodlama.io.bootcampProject.business.responses.users.instructors.CreateInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.GetAllInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.GetInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.UpdateInstructorResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorsController {
	private InstructorService instructorService;
	
	@GetMapping("/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id) {
		return this.instructorService.getById(id);
	}
    @PostMapping()
    public DataResult<CreateInstructorResponse> create(@Valid @RequestBody CreateInstructorRequest createInstructorRequest){
        return this.instructorService.add(createInstructorRequest);
    }
	@GetMapping()
	public DataResult<List<GetAllInstructorResponse>> getAll(){
		return this.instructorService.getAll();
	}
	@PutMapping()
	public DataResult<UpdateInstructorResponse> update(@Valid @RequestBody UpdateInstructorRequest updateInstructorRequest){
		return this.instructorService.update(updateInstructorRequest);
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.instructorService.delete(id);
	}
}