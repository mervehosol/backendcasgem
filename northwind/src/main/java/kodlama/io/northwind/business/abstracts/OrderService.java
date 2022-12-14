package kodlama.io.northwind.business.abstracts;

import java.util.List;



import kodlama.io.northwind.business.requests.orders.CreateOrderRequest;
import kodlama.io.northwind.business.responses.GetOrderResponse;
import kodlama.io.northwind.business.responses.orders.GetAllOrdersResponse;

public interface OrderService {
	List<GetAllOrdersResponse> getAll();
	void add(CreateOrderRequest createOrderRequest);
	
	GetOrderResponse getById(int id);
	
	
	}
