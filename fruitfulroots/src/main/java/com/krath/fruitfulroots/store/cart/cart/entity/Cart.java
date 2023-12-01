package com.krath.fruitfulroots.store.cart.cart.entity;

import com.krath.fruitfulroots.store.cart.item.entity.CartItem;
import com.krath.fruitfulroots.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItemList;
}
