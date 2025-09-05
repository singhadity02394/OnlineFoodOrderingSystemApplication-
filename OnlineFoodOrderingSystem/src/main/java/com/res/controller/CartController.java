package com.res.controller;

import com.res.entity.Cart;
import com.res.entity.FoodItem;
import com.res.entity.User;
import com.res.repository.FoodItemRepository;
import com.res.repository.UserRepository;
import com.res.servic.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    // Add item to cart
    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId, @RequestParam Long foodItemId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        FoodItem foodItem = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new RuntimeException("Food item not found with id: " + foodItemId));

        return cartService.addItemToCart(user, foodItem);
    }

    // Get cart of a user
    @GetMapping("/{userId}")
    public Cart getCartByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return cartService.getCartByUser(user);
    }

    // Clear cart
    @DeleteMapping("/{userId}/clear")
    public String clearCart(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        cartService.clearCart(user);
        return "Cart cleared for user with id: " + userId;
    }
}
