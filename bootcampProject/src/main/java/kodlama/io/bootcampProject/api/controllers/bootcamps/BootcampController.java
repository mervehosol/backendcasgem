package kodlama.io.bootcampProject.api.controllers.bootcamps;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.bootcampProject.business.abstracts.bootcamps.BootcampService;
import kodlama.io.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import kodlama.io.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import kodlama.io.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import kodlama.io.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import kodlama.io.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampController {
	private BootcampService bootcampService;
	
	@GetMapping("/{id}")
	public DataResult<GetBootcampResponse> getById(@PathVariable int id){
		return this.bootcampService.getById(id);
		
	}
	@PostMapping()
	public DataResult<CreateBootcampResponse> create(@Valid @RequestBody CreateBootcampRequest createBootcampRequest){
		return this.bootcampService.add(createBootcampRequest);
	}

	@PutMapping("update")
	public DataResult<UpdateBootcampResponse> update(@Valid @RequestBody UpdateBootcampRequest request){
		return bootcampService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	Result delete(@PathVariable int id) {
		return bootcampService.delete(id);
	}
}











