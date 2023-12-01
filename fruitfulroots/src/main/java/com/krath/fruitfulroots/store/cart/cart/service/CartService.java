package com.krath.fruitfulroots.store.cart.cart.service;

import com.krath.fruitfulroots.store.cart.cart.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CartService {
    List<Cart> getAllCarts();

    Optional<Cart> getCartById(long cartId);

    Cart createCart(Cart cart);

    void deleteCart(long cartId);
}
