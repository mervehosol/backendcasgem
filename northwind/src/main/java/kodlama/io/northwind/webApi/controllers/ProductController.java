package kodlama.io.northwind.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.business.requests.products.CreateProductRequest;
import kodlama.io.northwind.business.responses.products.CreateProductResponse;
import kodlama.io.northwind.business.responses.products.GetAllProductsResponse;
import kodlama.io.northwind.business.responses.products.GetProductResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
	private ProductService productService;



	@GetMapping("/getall")
	public List<GetAllProductsResponse> getAllProductsResponse() {
		return productService.getAll();
	}

	@GetMapping("/getbyname")
	public List<GetAllProductsResponse> getByName(String name) {
		return productService.getByName(name);
	}

	@GetMapping("/getbyid")
	public GetProductResponse getById(int id) {
		return productService.getById(id);
	}
	@PostMapping("/add") //
	public CreateProductResponse add(@RequestBody CreateProductRequest createProductRequest) {
		return productService.add(createProductRequest);
	}
	
	
}
