package com.krath.fruitfulroots.store.cart.cart.controller;

import com.krath.fruitfulroots.store.cart.cart.entity.Cart;
import com.krath.fruitfulroots.store.cart.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/getCartById")
    public ResponseEntity<Optional <Cart>> getCardById(long id){
        Optional<Cart> cart = cartService.getCartById(id);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/createCart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.createCart(cart));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @DeleteMapping("/delCart")
    public ResponseEntity deleteCart(@RequestBody long id){
        cartService.deleteCart(id);
        return ResponseEntity.ok("Cart Deletion is successful");
    }
}
