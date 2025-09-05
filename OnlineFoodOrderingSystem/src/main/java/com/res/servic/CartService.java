package com.res.servic;

import com.res.entity.Cart;
import com.res.entity.FoodItem;
import com.res.entity.User;

public interface CartService {
    Cart getCartByUser(User user);
    Cart addItemToCart(User user, FoodItem foodItem);
    void clearCart(User user);
}
