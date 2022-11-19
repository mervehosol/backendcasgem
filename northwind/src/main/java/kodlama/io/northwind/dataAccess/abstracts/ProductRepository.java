package kodlama.io.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwind.entities.Product;

//productrepository bir erişim katmanı
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List <Product> findByName(String name); 
	

}
