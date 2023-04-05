package sg.edu.nus.iss.day23workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day23workshop.model.OrderDetails;
import sg.edu.nus.iss.day23workshop.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {
    
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public OrderDetails getOrderDetails(Integer orderId) {
        return orderDetailsRepository.getOrderDetails(orderId);
    }
}
