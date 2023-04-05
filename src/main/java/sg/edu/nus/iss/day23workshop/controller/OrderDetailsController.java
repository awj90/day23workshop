package sg.edu.nus.iss.day23workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import sg.edu.nus.iss.day23workshop.model.OrderDetails;
import sg.edu.nus.iss.day23workshop.service.OrderDetailsService;

// @Controller
@RestController
@RequestMapping(path = "/order/total", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsController {
    
    @Autowired
    OrderDetailsService orderDetailsService;  

    // @GetMapping(path="/order/total/{orderId}")
    // public String getOrderDetails(@PathVariable Integer orderId, Model model) {
    //     OrderDetails orderDetails = orderDetailsService.getOrderDetails(orderId);
    //     if (orderDetails.getOrderDate() != null) {
    //         model.addAttribute("orderDetails", orderDetails);
    //         return "orderdetails";
    //     }
    //     model.addAttribute("orderId", orderId);
    //     return "notfound";
    // }

    @GetMapping(path="/{orderId}")
    public ResponseEntity<String> getOrderDetails(@PathVariable Integer orderId) {
        OrderDetails orderDetails = orderDetailsService.getOrderDetails(orderId);
        if (orderDetails.getOrderDate() != null) {
            return ResponseEntity.status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(orderDetails.toJsonObject().toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .contentType(MediaType.APPLICATION_JSON)
        .body(Json.createObjectBuilder().add("error", "order id %d not found".formatted(orderId)).build().toString());
    }
}

