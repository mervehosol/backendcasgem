package kodlama.io.northwind.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwind.business.abstracts.OrderService;
import kodlama.io.northwind.business.requests.orders.CreateOrderRequest;
import kodlama.io.northwind.business.responses.GetOrderResponse;
import kodlama.io.northwind.business.responses.orders.GetAllOrdersResponse;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@GetMapping("/getall")
	public List <GetAllOrdersResponse> getAll(){
		return orderService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateOrderRequest createOrderRequest) {
		orderService.add(createOrderRequest);
	}
	@GetMapping("/getbyid")
	public GetOrderResponse getById(int id){
		return orderService.getById(id );
	}
	
	
	

}
