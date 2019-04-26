package davidobrien.sdpca.orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository orderRepository;
	
	public List<Orders> getAllOrders(){
		List<Orders> allOrders = new ArrayList<Orders>();
		for(Orders PurchaseHistory: orderRepository.findAll()) {
			allOrders.add(PurchaseHistory);
		}
		return allOrders;
	}
	
	public Orders getOrderById(int id) {
		return orderRepository.findOne(id);
	}
	
	public void addOrder(Orders item) {
		orderRepository.save(item);
	}
	
	public void updateOrder(int id, Orders item) {
		orderRepository.save(item);
	}
	
	public void deleteOrder(int id) {
		orderRepository.delete(id);
	}

}