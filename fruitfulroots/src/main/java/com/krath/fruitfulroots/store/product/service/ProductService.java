package com.krath.fruitfulroots.store.product.service;

import com.krath.fruitfulroots.store.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    void saveProduct(Product product);
    Product findByName(String name);
    String updateProduct(Product product);
    List<Product> findAllProducts();
    void removeProduct(long id);
    List<Product> findByCategory(String category);
    Optional<Product> findById(long id);
    List<String> findDistinctCategories();

}
