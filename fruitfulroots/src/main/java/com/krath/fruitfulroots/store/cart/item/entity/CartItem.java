package com.krath.fruitfulroots.store.cart.item.entity;

import com.krath.fruitfulroots.store.cart.cart.entity.Cart;
import com.krath.fruitfulroots.store.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    private int quantity;
}
