package com.krath.fruitfulroots.store.cart.cart.service;

import com.krath.fruitfulroots.store.cart.cart.entity.Cart;
import com.krath.fruitfulroots.store.cart.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getCartById(long cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(long cartId) {
        cartRepository.deleteById(cartId);
    }
}
