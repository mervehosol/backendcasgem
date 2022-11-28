package kodlama.io.bootcampProject.api.controllers.applications;

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

import kodlama.io.bootcampProject.business.abstracts.applications.ApplicationService;
import kodlama.io.bootcampProject.business.requests.applications.CreateApplicationRequest;
import kodlama.io.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import kodlama.io.bootcampProject.business.responses.applications.CreateApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.GetApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController {
	private ApplicationService applicationService;

	@GetMapping("/{id}")
	public DataResult<GetApplicationResponse> getById(@PathVariable int id) {
		return this.applicationService.getById(id);

	}

	@PostMapping()
	public DataResult<CreateApplicationResponse> create(
			@Valid @RequestBody CreateApplicationRequest createApplicationRequest) {
		return this.applicationService.add(createApplicationRequest);

	}

	@PutMapping("update")
	public DataResult<UpdateApplicationResponse> update(@Valid @RequestBody UpdateApplicationRequest request) {
		return applicationService.update(request);
	}

	@DeleteMapping("deleteById/{id}")
	Result delete(@PathVariable int id) {
		return applicationService.delete(id);
	}

	@GetMapping("getAll")
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		return applicationService.getAll();
	}
}
