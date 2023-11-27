package com.krath.fruitfulroots.store.product.repository;

import com.krath.fruitfulroots.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.productName = :productName")
    Product findProductByName(@Param("productName") String productName);

    @Query("select p from Product p where p.category = :category")
    List<Product> productCategoryList(@Param("category") String category);

}
