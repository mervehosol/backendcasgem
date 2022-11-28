package kodlama.io.bootcampProject.business.concretes.bootcamps;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.bootcampProject.business.abstracts.bootcamps.BootcampService;
import kodlama.io.bootcampProject.business.abstracts.users.InstructorService;
import kodlama.io.bootcampProject.business.constants.Messages;
import kodlama.io.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import kodlama.io.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import kodlama.io.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import kodlama.io.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import kodlama.io.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import kodlama.io.bootcampProject.core.utilities.exceptions.BusinessException;
import kodlama.io.bootcampProject.core.utilities.mapping.ModelMapperService;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import kodlama.io.bootcampProject.core.utilities.results.SuccessDataResult;
import kodlama.io.bootcampProject.core.utilities.results.SuccessResult;
import kodlama.io.bootcampProject.dataAccess.abstracts.bootcamps.BootcampRepository;
import kodlama.io.bootcampProject.entities.applications.Bootcamp;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;
	private InstructorService instructorService;

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		checkIfBootcampById(id);
		Bootcamp bootcamp = this.bootcampRepository.findById(id).get();

		GetBootcampResponse response = this.modelMapperService.forResponse().map(bootcamp, GetBootcampResponse.class);
		return new SuccessDataResult<GetBootcampResponse>(response);

	}

	@Override
	public Result delete(int id) {
		checkIfBootcampById(id);
		bootcampRepository.deleteById(id);
		return new SuccessResult(Messages.BootcampDeleted);
	}

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
		checkIfInstructorById(createBootcampRequest.getInstructorId());
		checkIfAppicationState(createBootcampRequest.getState());
		
		Bootcamp bootcamp = this.modelMapperService.forRequest().map(createBootcampRequest, Bootcamp.class);
		this.bootcampRepository.save(bootcamp);

		CreateBootcampResponse createBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				CreateBootcampResponse.class);

		return new SuccessDataResult<CreateBootcampResponse>(createBootcampResponse, Messages.BootcampCreated);
	}

	@Override
	public DataResult<GetBootcampResponse> getByName(String name) {
		List<Bootcamp> bootcamp = this.bootcampRepository.findByName(name);

		GetBootcampResponse response = this.modelMapperService.forResponse().map(bootcamp, GetBootcampResponse.class);
		return new SuccessDataResult<GetBootcampResponse>(response);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
		Bootcamp bootcamp = modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
		bootcampRepository.save(bootcamp);

		UpdateBootcampResponse response = modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);
		return new SuccessDataResult<UpdateBootcampResponse>(response, Messages.BootcampUpdated);
	}

	private void checkIfInstructorById(int id) {
		instructorService.getById(id);
	}

	private void checkIfBootcampById(int id) {
		if (!this.bootcampRepository.existsById(id)) {
			throw new BusinessException(Messages.BootcampIdNotExist);
		}
	}
	private void checkIfAppicationState(int state) {
		if (state == 2) {
			throw new BusinessException(Messages.ApplicationStateClosed);
		}

	}

}
