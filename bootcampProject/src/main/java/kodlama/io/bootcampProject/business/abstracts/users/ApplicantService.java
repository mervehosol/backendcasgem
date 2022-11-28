package kodlama.io.bootcampProject.business.abstracts.users;



import java.util.List;

import kodlama.io.bootcampProject.business.requests.users.applicants.CreateApplicantRequest;
import kodlama.io.bootcampProject.business.requests.users.applicants.UpdateApplicantRequest;
import kodlama.io.bootcampProject.business.responses.users.applicants.CreateApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.GetAllApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.GetApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.UpdateApplicantResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;

public interface ApplicantService {
	Result delete(int id);

	DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);

	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);

	DataResult<List<GetAllApplicantResponse>> getAll();

	DataResult<GetApplicantResponse> getById(int id);
	
}
