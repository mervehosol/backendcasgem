package kodlama.io.bootcampProject.dataAccess.abstracts.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.bootcampProject.entities.users.Applicant;
@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

	Applicant findByIdentityNo(String identityNo);

}
