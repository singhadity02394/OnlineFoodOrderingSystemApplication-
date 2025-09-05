package com.res.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.res.entity.Cart;
import com.res.entity.FoodItem;
import com.res.entity.User;
import com.res.repository.CartRepository;
import com.res.servic.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartByUser(User user) {
        return cartRepository.findByUser(user).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            newCart.setItems(new ArrayList<>());
            newCart.setTotalPrice(0.0);
            return cartRepository.save(newCart);
        });
    }

    @Override
    public Cart addItemToCart(User user, FoodItem foodItem) {
        Cart cart = getCartByUser(user);
        cart.getItems().add(foodItem);
        cart.setTotalPrice(cart.getTotalPrice() + foodItem.getPrice());
        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(User user) {
        Cart cart = getCartByUser(user);
        cart.getItems().clear();
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);
    }
}

