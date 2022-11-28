package kodlama.io.bootcampProject.dataAccess.abstracts.blackList;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.bootcampProject.entities.blackList.BlackList;



public interface BlackListRepository extends JpaRepository<BlackList, Integer> {
	BlackList getByApplicantId(int applicantId);
	
}