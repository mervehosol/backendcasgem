package kodlama.io.northwind.business.abstracts;

import java.util.List;

import kodlama.io.northwind.business.requests.categories.CreateCategoryRequest;
import kodlama.io.northwind.business.requests.categories.UpdateCategoryRequest;
import kodlama.io.northwind.business.responses.categories.CreateCategoryResponse;
import kodlama.io.northwind.business.responses.categories.DeleteCategoryResponse;
import kodlama.io.northwind.business.responses.categories.GetAllCategoriesResponse;
import kodlama.io.northwind.business.responses.categories.UpdateCategoryResponse;

public interface CategoryService {
	List <GetAllCategoriesResponse> getAll();
	CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest);
	UpdateCategoryResponse update (UpdateCategoryRequest updateCategoryRequest);
	DeleteCategoryResponse deleteById(int id);
	

}
