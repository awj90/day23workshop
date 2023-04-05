package sg.edu.nus.iss.day23workshop.repository;

public class DBQueries {
    public static final String SELECT_ORDER_DETAILS = "select o.id as order_id, o.order_date, o.customer_id, sum(od.quantity * od.unit_price * od.discount) as total_price, sum(od.quantity * p.standard_cost) as cost_price from orders o left join order_details od on o.id = od.order_id left join products p on od.product_id = p.id where o.id = ?";
}
