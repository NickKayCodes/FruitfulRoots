package com.krath.fruitfulroots.store.cart.item.service;

import com.krath.fruitfulroots.store.cart.item.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CartItemService {
    List<CartItem> getAllCartItems();

    Optional<CartItem> getCartItemById(long cartId);

    CartItem createCartItem(CartItem cartItem);

    void deleteCartItem(long cartItemId);
}
