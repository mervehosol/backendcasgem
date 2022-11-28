package kodlama.io.bootcampProject.dataAccess.abstracts.bootcamps;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.bootcampProject.entities.applications.Bootcamp;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Integer>{

	List<Bootcamp>  findByName(String name);

}
