package com.res.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.res.entity.Cart;
import com.res.entity.Order;
import com.res.entity.Restaurant;
import com.res.entity.User;
import com.res.repository.CartRepository;
import com.res.repository.OrderRepository;
import com.res.servic.CartService;
import com.res.servic.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired private OrderRepository orderRepository;
    @Autowired private CartService cartService;
    @Autowired private CartRepository cartRepository;

    @Override
    public Order placeOrder(User user, Restaurant restaurant) {
        Cart cart = cartService.getCartByUser(user);

        Order order = Order.builder()
                .customer(user)
                .restaurant(restaurant)
                .items(cart.getItems())
                .totalAmount(cart.getTotalPrice())
                .status(Order.OrderStatus.PLACED)
                .build();

        Order savedOrder = orderRepository.save(order);

        // clear cart after placing order
        cartService.clearCart(user);

        return savedOrder;
    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByCustomer(user);
    }

    @Override
    public List<Order> getOrdersByRestaurant(Restaurant restaurant) {
        return orderRepository.findByRestaurant(restaurant);
    }

    @Override
    public Order updateOrderStatus(Long orderId, Order.OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
