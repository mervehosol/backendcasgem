package kodlama.io.northwind.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.northwind.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{



}
