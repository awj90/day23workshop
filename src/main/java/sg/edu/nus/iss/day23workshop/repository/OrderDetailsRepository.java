package sg.edu.nus.iss.day23workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day23workshop.model.OrderDetails;
import static sg.edu.nus.iss.day23workshop.repository.DBQueries.*;

@Repository
public class OrderDetailsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public OrderDetails getOrderDetails(Integer orderId) {
        List<OrderDetails> orderDetails = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_ORDER_DETAILS, orderId);
        while (rs.next()) {
            orderDetails.add(OrderDetails.create(rs));
        }
        return orderDetails.get(0);
    }
}
