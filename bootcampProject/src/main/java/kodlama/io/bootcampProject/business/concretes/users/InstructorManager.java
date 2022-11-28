package kodlama.io.bootcampProject.business.concretes.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.bootcampProject.business.abstracts.users.InstructorService;
import kodlama.io.bootcampProject.business.constants.Messages;
import kodlama.io.bootcampProject.business.requests.users.instructors.CreateInstructorRequest;
import kodlama.io.bootcampProject.business.requests.users.instructors.UpdateInstructorRequest;
import kodlama.io.bootcampProject.business.responses.users.instructors.CreateInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.GetAllInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.GetInstructorResponse;
import kodlama.io.bootcampProject.business.responses.users.instructors.UpdateInstructorResponse;
import kodlama.io.bootcampProject.core.utilities.exceptions.BusinessException;
import kodlama.io.bootcampProject.core.utilities.mapping.ModelMapperService;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import kodlama.io.bootcampProject.core.utilities.results.SuccessDataResult;
import kodlama.io.bootcampProject.core.utilities.results.SuccessResult;
import kodlama.io.bootcampProject.dataAccess.abstracts.users.InstructorRepository;
import kodlama.io.bootcampProject.entities.users.Instructor;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
	private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfInstructorById(id);
		this.instructorRepository.deleteById(id);
		return new SuccessResult(Messages.InstructorDeleted);
	}

	private void checkIfInstructorById(int id) {
		if (!this.instructorRepository.existsById(id)) {
			throw new BusinessException(Messages.InstructorIdNotExist);
		}
	}

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
		checkIfInstructorByIdentityNo(createInstructorRequest.getIdentityNo());
		Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
		this.instructorRepository.save(instructor);

		CreateInstructorResponse createInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				CreateInstructorResponse.class);
		return new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse, Messages.InstructorCreated);
	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = this.instructorRepository.findAll();
		List<GetAllInstructorResponse> response = instructors.stream().map(
				instructor -> this.modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		checkIfInstructorByIdentityNo(updateInstructorRequest.getIdentityNo());
		Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);

		this.instructorRepository.save(instructor);
		UpdateInstructorResponse response = this.modelMapperService.forResponse().map(instructor,
				UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(response, Messages.InstructorUpdated);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		checkIfInstructorById(id);
		Instructor instructor = this.instructorRepository.findById(id).get();

		GetInstructorResponse response = this.modelMapperService.forResponse().map(instructor,
				GetInstructorResponse.class);

		return new SuccessDataResult<GetInstructorResponse>(response);
	}

	private void checkIfInstructorByIdentityNo(String identityNo) {
		Instructor currInstructor = this.instructorRepository.findByIdentityNo(identityNo);
		if (currInstructor != null) {
			throw new BusinessException(Messages.InstructorExist);
		}

	}

}
