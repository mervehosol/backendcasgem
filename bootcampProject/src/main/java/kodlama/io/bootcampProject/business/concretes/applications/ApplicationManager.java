package kodlama.io.bootcampProject.business.concretes.applications;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.bootcampProject.business.abstracts.applications.ApplicationService;
import kodlama.io.bootcampProject.business.abstracts.blackList.BlackListService;
import kodlama.io.bootcampProject.business.abstracts.bootcamps.BootcampService;
import kodlama.io.bootcampProject.business.abstracts.users.ApplicantService;
import kodlama.io.bootcampProject.business.constants.Messages;
import kodlama.io.bootcampProject.business.requests.applications.CreateApplicationRequest;
import kodlama.io.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import kodlama.io.bootcampProject.business.responses.applications.CreateApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.GetApplicationResponse;
import kodlama.io.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import kodlama.io.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import kodlama.io.bootcampProject.core.utilities.exceptions.BusinessException;
import kodlama.io.bootcampProject.core.utilities.mapping.ModelMapperService;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import kodlama.io.bootcampProject.core.utilities.results.SuccessDataResult;
import kodlama.io.bootcampProject.core.utilities.results.SuccessResult;
import kodlama.io.bootcampProject.dataAccess.abstracts.applications.ApplicationRepository;
import kodlama.io.bootcampProject.entities.evaluations.Application;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
	private ApplicationRepository applicationRepository;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;
	private BootcampService bootcampService;
	private BlackListService blackListService;
	

	@Override
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		List<Application> applications = applicationRepository.findAll();
		List<GetAllApplicationResponse> getAllApplicationsResponse = applications.stream().map(
				application -> this.modelMapperService.forResponse().map(application, GetAllApplicationResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicationResponse>>(getAllApplicationsResponse, Messages.ApplicationListed);
	}

	@Override
	public DataResult<GetApplicationResponse> getById(int id) {
		checkIfApplicationExistsById(id);
		Application application = applicationRepository.findById(id).get();
		GetApplicationResponse getApplicationResponse = modelMapperService.forResponse().map(application, GetApplicationResponse.class);
		return new SuccessDataResult<GetApplicationResponse>(getApplicationResponse);
	}

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
		checkIfApplicantExists(createApplicationRequest.getApplicantId());
		checkIfBootcampExists(createApplicationRequest.getBootcampId());
		checkIfApplicationInBlackListById(createApplicationRequest.getApplicantId());
		checkIfBootcampState(createApplicationRequest.getBootcampId());
		
		Application application = modelMapperService.forRequest().map(createApplicationRequest, Application.class);
		applicationRepository.save(application);
		CreateApplicationResponse createApplicationResponse = modelMapperService.forResponse().map(application, CreateApplicationResponse.class);
		return new SuccessDataResult<CreateApplicationResponse>(createApplicationResponse, Messages.ApplicationCreated);
	}
	
	@Override
	public Result delete(int id) {
		checkIfApplicationExistsById(id);
		applicationRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicationDeleted);
	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
		checkIfBootcampExists(updateApplicationRequest.getBootcampId());
		checkIfApplicantExists(updateApplicationRequest.getApplicantId());
		checkIfApplicationExistsById(updateApplicationRequest.getId());
		
		Application application = modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
		applicationRepository.save(application);
		UpdateApplicationResponse updateApplicationResponse = modelMapperService.forResponse().map(application, UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(updateApplicationResponse, Messages.ApplicationUpdated);
	}
	
	
	private void checkIfApplicationExistsById(int id) {
		if(!this.applicationRepository.existsById(id)) {
			throw new BusinessException(Messages.ApplicantionIdNotExists);
		}
	}
	
	
	private void checkIfApplicationInBlackListById(int id) {
		this.blackListService.checkApplicantAlreadyExistInBlackList(id);
	}
	
	private void checkIfApplicantExists(int applicantId) {
		this.applicantService.getById(applicantId);
	}
	
	private void checkIfBootcampExists(int bootcampId) {
		this.bootcampService.getById(bootcampId);
	}
	private void checkIfBootcampState(int bootcampId) {
		DataResult<GetBootcampResponse> bootcamp =this.bootcampService.getById(bootcampId);
		if(bootcamp.getData().getState()== 2) {
			throw new BusinessException(Messages.BootcampStateClosed);
		}
	}

}
