package kodlama.io.northwind.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwind.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
