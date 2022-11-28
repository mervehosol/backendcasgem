package kodlama.io.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kodlama.io.bootcampProject.business.constants.Messages;
import kodlama.io.bootcampProject.business.requests.users.instructors.CreateInstructorRequest;
import kodlama.io.bootcampProject.business.responses.users.instructors.CreateInstructorResponse;
import kodlama.io.bootcampProject.core.utilities.results.DataResult;
import kodlama.io.bootcampProject.core.utilities.results.SuccessDataResult;
import kodlama.io.bootcampProject.entities.users.Instructor;
import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.business.requests.products.CreateProductRequest;
import kodlama.io.northwind.business.responses.products.CreateProductResponse;
import kodlama.io.northwind.business.responses.products.GetAllProductsResponse;
import kodlama.io.northwind.business.responses.products.GetProductResponse;
import kodlama.io.northwind.core.utilities.mapping.ModelMapperService;
import kodlama.io.northwind.dataAccess.abstracts.ProductRepository;
import kodlama.io.northwind.entities.Category;
import kodlama.io.northwind.entities.Employee;
import kodlama.io.northwind.entities.Product;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {


	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;
	


	@Override
	public List<GetAllProductsResponse> getAll() {
		List<Product> products = this.productRepository.findAll();
		List<GetAllProductsResponse> getAllProductsResponses= new ArrayList<GetAllProductsResponse>();
		
		for (Product product : products) {
			GetAllProductsResponse response = new GetAllProductsResponse();
			response.setCategoryName(product.getCategory().getName());
			response.setName(product.getName());
			response.setId(product.getId());
			response.setUnitPrice(product.getUnitPrice());
			response.setUnitsInStock(product.getUnitsInStock());
			getAllProductsResponses.add(response);
		}
		return getAllProductsResponses;
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createProductRequest) {
		/*Product product=this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productRepository.save(product);
		CreateProductResponse createProductResponse =this.modelMapperService.forResponse().map(product, CreateProductResponse.class);
		return createProductResponse;*/
		
		
		
		
		
/*
		
	public DataResult<CreateProductResponse> add(CreateProductRequest createProductRequest) {
		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productRepository.save(product);

		CreateProductResponse createProductResponse = this.modelMapperService.forResponse().map(product,
				CreateProductResponse.class);
		return new SuccessDataResult<CreateProductResponse>(createProductResponse, Messages.InstructorCreated);
	}
	
	*/
	
		
	}

	@Override
	public List<GetAllProductsResponse> getByName(String name) {
		List<Product> products = productRepository.findByName(name);
		List<GetAllProductsResponse>getAllProductsResponses = new ArrayList<GetAllProductsResponse>();
		for (Product product: products) {
			GetAllProductsResponse response = new GetAllProductsResponse();
			response.setId(product.getId());
			response.setName(product.getName());
			response.setUnitPrice(product.getUnitPrice());
			response.setUnitsInStock(product.getUnitsInStock());
			response.setCategoryName(product.getCategory().getName());
			getAllProductsResponses.add(response);
		}
		return getAllProductsResponses;
	}

	@Override
	public GetProductResponse getById(int id) {
		/*Product product =productRepository.findById(id).get();
		GetProductResponse productResponse = new GetProductResponse();
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setCategoryName(product.getCategory().getName());
		productResponse.setUnitPrice(product.getUnitPrice());
		productResponse.setUnitsInStock(product.getUnitsInStock());
		return productResponse;*/,
		
		
		
		
	}


}
