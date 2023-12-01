package com.krath.fruitfulroots.store.cart.item.controller;

import com.krath.fruitfulroots.store.cart.item.entity.CartItem;
import com.krath.fruitfulroots.store.cart.item.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
    @Autowired
    CartItemService cartItemService;

    @GetMapping("/getItems")
    public ResponseEntity<List<CartItem>> getAllCartItems(){
     return ResponseEntity.ok(cartItemService.getAllCartItems());
    }

    @GetMapping("/getCartItemById")
    public ResponseEntity<Optional<CartItem>> getCartItemById(@RequestBody long id){
        return ResponseEntity.ok(cartItemService.getCartItemById(id));
    }

    @PostMapping("/createCartItem")
    public ResponseEntity<CartItem> createCartItem(CartItem cartItem){
        return ResponseEntity.ok(cartItemService.createCartItem(cartItem));
    }

    @PostMapping("/delCartItem")
    public ResponseEntity deleteCartItem(@RequestBody long id){
        cartItemService.deleteCartItem(id);
        return ResponseEntity.ok("Cart item removed");
    }
}
