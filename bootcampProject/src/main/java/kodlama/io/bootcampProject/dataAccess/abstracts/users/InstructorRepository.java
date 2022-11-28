package kodlama.io.bootcampProject.dataAccess.abstracts.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.bootcampProject.entities.users.Instructor;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{
 Instructor findByIdentityNo(String identityNo);
 
}
