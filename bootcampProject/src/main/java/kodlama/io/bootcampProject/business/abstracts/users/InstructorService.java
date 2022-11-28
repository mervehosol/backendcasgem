package kodlama.io.bootcampProject.business.abstracts.users;

import java.util.List;

import kodlama.io.bootcampProject.business.requests.users.instructors.CreateInstructorRequest;
import kodlama.io.bootcampProject.business.requests.users.instructors.UpdateInstructorRequest;
import kodlama.io.bootcampProject.business.responses.users.instructors.CreateInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.GetAllInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.GetInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.UpdateInstructorResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;

public interface InstructorService {
	Result delete(int id);
	DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);
	DataResult<List<GetAllInstructorResponse>> getAll();
	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
	DataResult<GetInstructorResponse> getById(int id);
}
