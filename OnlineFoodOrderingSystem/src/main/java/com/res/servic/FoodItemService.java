package com.res.servic;

import java.util.List;

import com.res.entity.FoodItem;
import com.res.entity.Restaurant;

public interface FoodItemService {
    FoodItem addFoodItem(FoodItem foodItem, Restaurant restaurant);
    List<FoodItem> getMenuByRestaurant(Restaurant restaurant);
}
