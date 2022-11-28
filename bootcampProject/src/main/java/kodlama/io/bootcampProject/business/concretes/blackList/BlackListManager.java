package kodlama.io.bootcampProject.business.concretes.blackList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import kodlama.io.bootcampProject.business.abstracts.blackList.BlackListService;
import kodlama.io.bootcampProject.business.abstracts.users.ApplicantService;
import kodlama.io.bootcampProject.business.constants.Messages;
import kodlama.io.bootcampProject.business.requests.blackList.CreateBlackListRequest;
import kodlama.io.bootcampProject.business.requests.blackList.UpdateBlackListRequest;
import kodlama.io.bootcampProject.business.responses.blackList.CreateBlackListResponse;
import kodlama.io.bootcampProject.business.responses.blackList.GetAllBlackListsResponse;
import kodlama.io.bootcampProject.business.responses.blackList.GetBlackListResponse;
import kodlama.io.bootcampProject.business.responses.blackList.UpdateBlackListResponse;
import kodlama.io.bootcampProject.core.utilities.exceptions.BusinessException;
import kodlama.io.bootcampProject.core.utilities.mapping.ModelMapperService;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;
import kodlama.io.bootcampProject.core.utilities.results.SuccessDataResult;
import kodlama.io.bootcampProject.core.utilities.results.SuccessResult;
import kodlama.io.bootcampProject.dataAccess.abstracts.blackList.BlackListRepository;
import kodlama.io.bootcampProject.entities.blackList.BlackList;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlackListManager implements BlackListService {
	private BlackListRepository blackListRepository;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;

	@Override
	public DataResult<List<GetAllBlackListsResponse>> getAll() {
		List<BlackList> blackLists = blackListRepository.findAll();
		List<GetAllBlackListsResponse> allBlackListsResponses = blackLists.stream()
				.map(blackList -> this.modelMapperService.forResponse().map(blackList, GetAllBlackListsResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllBlackListsResponse>>(allBlackListsResponses, Messages.BlackListListed);
	}

	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		checkIfBlackListExistsById(id);
		BlackList blackList = blackListRepository.findById(id).get();
		GetBlackListResponse getBlackListResponse = modelMapperService.forResponse().map(blackList,
				GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(getBlackListResponse);
	}

	@Override
	public DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest) {
		checkIfApplicantExists(createBlackListRequest.getApplicantId());
		BlackList blackList = modelMapperService.forRequest().map(createBlackListRequest, BlackList.class);
		blackListRepository.save(blackList);
		CreateBlackListResponse createBlackListResponse = modelMapperService.forResponse().map(blackList,
				CreateBlackListResponse.class);
		return new SuccessDataResult<CreateBlackListResponse>(createBlackListResponse, Messages.BlackListCreated);
	}

	@Override
	public Result delete(int id) {
		checkIfBlackListExistsById(id);
		blackListRepository.deleteById(id);
		return new SuccessResult(Messages.BlackListDeleted);
	}

	@Override
	public DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest) {
		checkIfApplicantExists(updateBlackListRequest.getApplicantId());
		checkIfBlackListExistsById(updateBlackListRequest.getId());
		BlackList blackList = modelMapperService.forRequest().map(updateBlackListRequest, BlackList.class);
		blackListRepository.save(blackList);
		UpdateBlackListResponse updateBlackListResponse = modelMapperService.forResponse().map(blackList,
				UpdateBlackListResponse.class);

		return new SuccessDataResult<UpdateBlackListResponse>(updateBlackListResponse, Messages.BlackListUpdated);
	}
	
	@Override
	public DataResult<GetBlackListResponse> getByApplicantId(int Applicantid) {
		BlackList blackList = blackListRepository.getByApplicantId(Applicantid);
		GetBlackListResponse blackListResponse = modelMapperService.forResponse().map(blackList, GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(blackListResponse);
	}
	
	private void checkIfBlackListExistsById(int id) {
		BlackList blackList = blackListRepository.findById(id).orElse(null);
		if (blackList == null) {
			throw new BusinessException(Messages.BlackListNoExists);
		}
	}

	private void checkIfApplicantExists(int applicantId) {
		var result = applicantService.getById(applicantId);
		if (result == null) {
			throw new BusinessException(Messages.ApplicantNoExists);
		}
		
		
	}

	@Override
	public void checkApplicantAlreadyExistInBlackList(int id) {
		if(this.blackListRepository.getByApplicantId(id)!= null) {
			throw new BusinessException(Messages.ApplicantIsExistInBlackList);
		}
		
	}

	

}