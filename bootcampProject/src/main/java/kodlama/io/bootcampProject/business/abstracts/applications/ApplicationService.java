package kodlama.io.bootcampProject.business.abstracts.applications;

import java.util.List;

import kodlama.io.bootcampProject.business.requests.applications.CreateApplicationRequest;
import kodlama.io.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import kodlama.io.bootcampProject.business.responses.applications.CreateApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.GetApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;

public interface ApplicationService {

	DataResult<GetApplicationResponse> getById(int id);

	DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);

	DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicantionRequest);

	Result delete(int id);

	DataResult<List<GetAllApplicationResponse>> getAll();

}
