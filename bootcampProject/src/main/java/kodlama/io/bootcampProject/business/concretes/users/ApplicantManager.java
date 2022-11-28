package kodlama.io.bootcampProject.business.concretes.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.bootcampProject.business.abstracts.users.ApplicantService;
import kodlama.io.bootcampProject.business.constants.Messages;
import kodlama.io.bootcampProject.business.requests.users.applicants.CreateApplicantRequest;
import kodlama.io.bootcampProject.business.requests.users.applicants.UpdateApplicantRequest;
import kodlama.io.bootcampProject.business.responses.users.applicants.CreateApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.GetAllApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.GetApplicantResponse;
import kodlama.io.bootcampProject.business.responses.users.applicants.UpdateApplicantResponse;
import kodlama.io.bootcampProject.core.utilities.exceptions.BusinessException;
import kodlama.io.bootcampProject.core.utilities.mapping.ModelMapperService;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import kodlama.io.bootcampProject.core.utilities.results.SuccessDataResult;
import kodlama.io.bootcampProject.core.utilities.results.SuccessResult;
import kodlama.io.bootcampProject.dataAccess.abstracts.users.ApplicantRepository;
import kodlama.io.bootcampProject.entities.users.Applicant;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicantManager implements ApplicantService {
	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkExistApplicantId(id);
		this.applicantRepository.deleteById(id);
		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		checkIfApplicantByIdentityNo(createApplicantRequest.getIdentityNo());
		Applicant applicant = this.modelMapperService.forResponse().map(createApplicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);
		CreateApplicantResponse applicantResponse = this.modelMapperService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(applicantResponse, Messages.ApplicantCreated);
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
		checkExistApplicantId(updateApplicantRequest.getUserId());
		Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);
		UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				UpdateApplicantResponse.class);

		return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse, Messages.InstructorUpdated);
	}

	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		List<Applicant> applicants = this.applicantRepository.findAll();
		List<GetAllApplicantResponse> allApplicantResponses = applicants.stream()
				.map(applicant -> this.modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(allApplicantResponses);
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		checkExistApplicantId(id);
		Applicant applicant = this.applicantRepository.findById(id).get();
		GetApplicantResponse getApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				GetApplicantResponse.class);

		return new SuccessDataResult<GetApplicantResponse>(getApplicantResponse);
	}

	private void checkIfApplicantByIdentityNo(String identityNo) {
		Applicant currApplicant = this.applicantRepository.findByIdentityNo(identityNo);
		if (currApplicant != null) {
			throw new BusinessException(Messages.ApplicantExist);
		}
	}

	
	private void checkExistApplicantId(int applicantId) {
		if (!this.applicantRepository.existsById(applicantId)) {
			throw new BusinessException(Messages.ApplicantNoExists);
		}
		
	}
}