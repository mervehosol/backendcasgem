package kodlama.io.northwind.business.abstracts;

import java.util.List;

import kodlama.io.bootcampProject.business.requests.users.instructors.CreateInstructorRequest;
import kodlama.io.bootcampProject.business.responses.users.instructors.CreateInstructorResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.northwind.business.requests.products.CreateProductRequest;
import kodlama.io.northwind.business.responses.products.CreateProductResponse;
import kodlama.io.northwind.business.responses.products.GetAllProductsResponse;
import kodlama.io.northwind.business.responses.products.GetProductResponse;

public interface ProductService {
	
	List<GetAllProductsResponse> getAll();
	
	CreateProductResponse add(CreateProductRequest createProductRequest);
	
	List<GetAllProductsResponse> getByName(String name);
	
	GetProductResponse getById(int id);
/*DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);*/
	
}
