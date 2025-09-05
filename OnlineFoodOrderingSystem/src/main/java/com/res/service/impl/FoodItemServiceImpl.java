package com.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.res.entity.FoodItem;
import com.res.entity.Restaurant;
import com.res.repository.FoodItemRepository;
import com.res.servic.FoodItemService;

import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public FoodItem addFoodItem(FoodItem foodItem, Restaurant restaurant) {
        foodItem.setRestaurant(restaurant);
        return foodItemRepository.save(foodItem);
    }

    @Override
    public List<FoodItem> getMenuByRestaurant(Restaurant restaurant) {
        return foodItemRepository.findByRestaurant(restaurant);
    }
}

