package sg.edu.nus.iss.day23workshop.model;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class OrderDetails {
    private Integer orderId;
    private Date orderDate;
    private Integer customerId;
    private Double totalPrice;
    private Double costPrice;
    
    public OrderDetails() {}

    public OrderDetails(Integer orderId, Date orderDate, Integer customerId, Double totalPrice, Double costPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.costPrice = costPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Double getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
                + ", totalPrice=" + totalPrice + ", costPrice=" + costPrice + "]";
    }

    public static OrderDetails create(SqlRowSet rs) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(rs.getInt("order_id"));
        orderDetails.setOrderDate(rs.getDate("order_date"));
        orderDetails.setCustomerId(rs.getInt("customer_id"));
        orderDetails.setTotalPrice(rs.getDouble("total_price"));
        orderDetails.setCostPrice(rs.getDouble("cost_price"));
        return orderDetails;
    }

    public JsonObject toJsonObject() {
        return Json.createObjectBuilder().add("order_id", this.getOrderId())
                                        .add("order_date", (this.getOrderDate().toString()))
                                        .add("customer_id", this.getCustomerId())
                                        .add("total_price", this.getTotalPrice())
                                        .add("cost_price", this.getCostPrice())
                                        .build();
    }
}
