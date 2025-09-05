package com.res.controller;

import com.res.entity.FoodItem;
import com.res.entity.Restaurant;
import com.res.repository.RestaurantRepository;
import com.res.servic.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-items")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Add FoodItem for a specific restaurant
    @PostMapping("/restaurant/{restaurantId}")
    public FoodItem addFoodItem(@PathVariable Long restaurantId, @RequestBody FoodItem foodItem) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
        return foodItemService.addFoodItem(foodItem, restaurant);
    }

    // Get all menu items of a restaurant
    @GetMapping("/restaurant/{restaurantId}")
    public List<FoodItem> getFoodItemsByRestaurant(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
        return foodItemService.getMenuByRestaurant(restaurant);
    }
}
