package kodlama.io.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.northwind.business.abstracts.OrderService;
import kodlama.io.northwind.business.requests.orders.CreateOrderRequest;
import kodlama.io.northwind.business.responses.GetOrderResponse;
import kodlama.io.northwind.business.responses.orders.GetAllOrdersResponse;
import kodlama.io.northwind.dataAccess.abstracts.EmployeeRepository;
import kodlama.io.northwind.dataAccess.abstracts.OrderRepository;
import kodlama.io.northwind.entities.Employee;
import kodlama.io.northwind.entities.Order;

@Service
public class OrderManager implements OrderService {

	private OrderRepository orderRepository;

	public OrderManager(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public List<GetAllOrdersResponse> getAll() {
		List<Order> orders = orderRepository.findAll();
		List<GetAllOrdersResponse> getAllOrdersResponses = new ArrayList<GetAllOrdersResponse>();

		for (Order order : orders) {
			GetAllOrdersResponse responseItem = new GetAllOrdersResponse();
			responseItem.setId(order.getId());
			responseItem.setDate(order.getDate());
			responseItem.setFirstName(order.getEmployee().getFirstName());
			responseItem.setLastName(order.getEmployee().getLastName());
			responseItem.setSalary(order.getEmployee().getSalary());
			getAllOrdersResponses.add(responseItem);
		}
		return getAllOrdersResponses;
	}

	@Override
	public void add(CreateOrderRequest createOrderRequest) {
		
		Order order = new Order();
		order.setDate(createOrderRequest.getDate());
		
		orderRepository.save(order);

	}

	@Override
	public GetOrderResponse getById(int id) {

		GetOrderResponse getOrderResponse = new GetOrderResponse();
		Order order = this.orderRepository.findById(id).get();
		getOrderResponse.setId(order.getId());
		getOrderResponse.setDate(order.getDate());
		
		getOrderResponse.setEmployeeId(order.getEmployee().getId());
		return getOrderResponse;
	}

}
