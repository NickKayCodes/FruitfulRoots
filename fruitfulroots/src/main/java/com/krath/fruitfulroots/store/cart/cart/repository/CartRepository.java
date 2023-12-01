package com.krath.fruitfulroots.store.cart.cart.repository;

import com.krath.fruitfulroots.store.cart.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
