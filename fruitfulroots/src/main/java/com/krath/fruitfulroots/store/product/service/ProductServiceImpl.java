package com.krath.fruitfulroots.store.product.service;

import com.krath.fruitfulroots.store.product.entity.Product;
import com.krath.fruitfulroots.store.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public String updateProduct(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());
        if(product1.isEmpty()){
            throw new IllegalArgumentException("PRODUCT NOT FOUND");
        }
        Product updateProduct = product1.get();
        updateProduct.setProductName(product.getProductName());
        updateProduct.setCategory(product.getCategory());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setStockQuantity(product.getStockQuantity());
        saveProduct(updateProduct);
        return "Product updated successfully";
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void removeProduct(long id) {
        Optional<Product> product = findById(id);
        try{
            if(product.isPresent()){
                productRepository.deleteById(id);
            }
        }catch (Exception e){
            throw new IllegalArgumentException("PRODUCT_NOT_FOUND");
        }
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.productCategoryList(category);
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }
}
