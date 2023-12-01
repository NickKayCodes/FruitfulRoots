package com.krath.fruitfulroots.store.cart.item.service;

import com.krath.fruitfulroots.store.cart.item.entity.CartItem;
import com.krath.fruitfulroots.store.cart.item.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public Optional<CartItem> getCartItemById(long cartId) {
        return cartItemRepository.findById(cartId);
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
