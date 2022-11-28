package kodlama.io.bootcampProject.business.abstracts.bootcamps;


import kodlama.io.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import kodlama.io.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import kodlama.io.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import kodlama.io.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import kodlama.io.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;

public interface BootcampService {

	DataResult<GetBootcampResponse> getById(int id);

	DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest);

	DataResult<GetBootcampResponse> getByName(String name);

	DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest);

	Result delete(int id);
	

}
