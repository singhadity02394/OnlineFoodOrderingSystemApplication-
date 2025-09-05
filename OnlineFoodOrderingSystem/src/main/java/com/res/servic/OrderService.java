package com.res.servic;

import com.res.entity.Order;
import com.res.entity.Restaurant;
import com.res.entity.User;
import java.util.List;

public interface OrderService {
    Order placeOrder(User user, Restaurant restaurant);
    List<Order> getOrdersByUser(User user);
    List<Order> getOrdersByRestaurant(Restaurant restaurant);
    Order updateOrderStatus(Long orderId, Order.OrderStatus status);
    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
}
