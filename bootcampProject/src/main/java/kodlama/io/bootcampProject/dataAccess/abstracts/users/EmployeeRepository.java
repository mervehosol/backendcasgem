package kodlama.io.bootcampProject.dataAccess.abstracts.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.bootcampProject.entities.users.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByIdentityNo(String identityNo);

}
