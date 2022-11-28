package kodlama.io.bootcampProject.dataAccess.abstracts.applications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.bootcampProject.entities.evaluations.Application;

@Repository
public interface ApplicationRepository  extends JpaRepository<Application, Integer>{

	Application findByApplicantId (int applicantId);
 
}
