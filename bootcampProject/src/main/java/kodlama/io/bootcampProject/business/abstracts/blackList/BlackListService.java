package kodlama.io.bootcampProject.business.abstracts.blackList;

import java.util.List;


import kodlama.io.bootcampProject.business.requests.blackList.CreateBlackListRequest;
import kodlama.io.bootcampProject.business.requests.blackList.UpdateBlackListRequest;
import kodlama.io.bootcampProject.business.responses.blackList.CreateBlackListResponse;
import kodlama.io.bootcampProject.business.responses.blackList.GetAllBlackListsResponse;
import kodlama.io.bootcampProject.business.responses.blackList.GetBlackListResponse;
import kodlama.io.bootcampProject.business.responses.blackList.UpdateBlackListResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.Result;

public interface BlackListService {

	DataResult<GetBlackListResponse> getById(int id);

	DataResult<List<GetAllBlackListsResponse>> getAll();

	DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest);

	Result delete(int id);

	DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest);

	DataResult<GetBlackListResponse> getByApplicantId(int applicantId);
	
	void checkApplicantAlreadyExistInBlackList(int id);
	

}
