package com.res.controller;

import com.res.entity.Order;
import com.res.entity.Restaurant;
import com.res.entity.User;
import com.res.repository.RestaurantRepository;
import com.res.repository.UserRepository;
import com.res.servic.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired private OrderService orderService;
    @Autowired private UserRepository userRepository;
    @Autowired private RestaurantRepository restaurantRepository;

    // Place order
    @PostMapping("/place")
    public Order placeOrder(@RequestParam Long userId, @RequestParam Long restaurantId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));

        return orderService.placeOrder(user, restaurant);
    }

    // Get single order
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Update order status
    @PutMapping("/{orderId}/status")
    public Order updateOrderStatus(@PathVariable Long orderId, @RequestParam Order.OrderStatus status) {
        return orderService.updateOrderStatus(orderId, status);
    }
}
