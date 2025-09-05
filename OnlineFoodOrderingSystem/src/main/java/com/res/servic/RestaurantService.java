package com.res.servic;

import java.util.List;

import com.res.entity.Restaurant;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(Long id);
}
