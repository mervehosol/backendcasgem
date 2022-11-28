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

import kodlama.io.bootcampProject.business.abstracts.users.ApplicantService;
import kodlama.io.bootcampProject.business.requests.users.applicants.CreateApplicantRequest;
import kodlama.io.bootcampProject.business.requests.users.applicants.UpdateApplicantRequest;
import kodlama.io.bootcampProject.business.responses.users.applicants.CreateApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.GetAllApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.GetApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.UpdateApplicantResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applicant") 
@AllArgsConstructor
public class ApplicantController {
	

	 private ApplicantService applicantService;

	    @PostMapping()
	    public DataResult<CreateApplicantResponse> create (@Valid @RequestBody CreateApplicantRequest createApplicantRequest) {
	        return this.applicantService.add(createApplicantRequest);
	    }
	    @PutMapping()
	    public DataResult<UpdateApplicantResponse> update(@Valid @RequestBody UpdateApplicantRequest updateApplicantRequest){
	        return this.applicantService.update(updateApplicantRequest);
	    }
	    @DeleteMapping("/{id}")
	    public Result  delete(@PathVariable int id){
	        return this.applicantService.delete(id);
	    }

	    @GetMapping("/{id}")
	    public DataResult<GetApplicantResponse> getById(@PathVariable int id){
	        return this.applicantService.getById(id);
	    }
	    @GetMapping()
	    public DataResult<List<GetAllApplicantResponse>> getAll(){
	        return this.applicantService.getAll();
	    }
}
