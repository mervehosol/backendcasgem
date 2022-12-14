package kodlama.io.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import kodlama.io.northwind.business.abstracts.CategoryService;

import kodlama.io.northwind.business.requests.categories.CreateCategoryRequest;
import kodlama.io.northwind.business.requests.categories.UpdateCategoryRequest;
import kodlama.io.northwind.business.responses.categories.CreateCategoryResponse;
import kodlama.io.northwind.business.responses.categories.DeleteCategoryResponse;
import kodlama.io.northwind.business.responses.categories.GetAllCategoriesResponse;
import kodlama.io.northwind.business.responses.categories.UpdateCategoryResponse;
import kodlama.io.northwind.dataAccess.abstracts.CategoryRepository;
import kodlama.io.northwind.entities.Category;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService {
	
	private CategoryRepository categoryRepository;


	@Override
	public UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest) {
		Category category = categoryRepository.findById(updateCategoryRequest.getId()).get();
				

		category.setId(updateCategoryRequest.getId());
		category.setName(updateCategoryRequest.getName());
		categoryRepository.save(category);

		UpdateCategoryResponse updateCategoryResponse = new UpdateCategoryResponse();
		updateCategoryResponse.setId(category.getId());
		updateCategoryResponse.setName(category.getName());
		return updateCategoryResponse;
	}

	

	@Override
	public DeleteCategoryResponse deleteById(int id) {
		Category category =categoryRepository.findById(id).get();
		categoryRepository.delete(category);
		
		DeleteCategoryResponse deleteCategoryResponse =new DeleteCategoryResponse();
		deleteCategoryResponse.setId(category.getId());
		deleteCategoryResponse.setName(category.getName());
		return deleteCategoryResponse;
		
	
	}


	@Override
	public List<GetAllCategoriesResponse> getAll() {

		List<Category> categories = categoryRepository.findAll();
		List<GetAllCategoriesResponse> getAllCategoriesResponses = new ArrayList<GetAllCategoriesResponse>();

		for (Category category : categories) {
			GetAllCategoriesResponse response = new GetAllCategoriesResponse();
			response.setId(category.getId());
			response.setName(category.getName());
			getAllCategoriesResponses.add(response);
		}
		return getAllCategoriesResponses;
	}

	@Override
	public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
		
		Category category = new Category();
		category.setName(createCategoryRequest.getName());
		category.setId(createCategoryRequest.getId());

		categoryRepository.save(category);
		CreateCategoryResponse createCategoryResponse =new CreateCategoryResponse();

		createCategoryResponse.setName(category.getName());
		createCategoryResponse.setId(category.getId());
		return createCategoryResponse;
	
	}

}
