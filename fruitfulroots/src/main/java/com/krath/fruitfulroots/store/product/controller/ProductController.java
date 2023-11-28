package com.krath.fruitfulroots.store.product.controller;

import com.krath.fruitfulroots.store.product.entity.Product;
import com.krath.fruitfulroots.store.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.findAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Product> findByName(@RequestBody String name){
        Product product = productService.findByName(name);
        if (product !=null){
            return ResponseEntity.ok(product);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> newProduct(@RequestBody Product product){
        try{
            productService.saveProduct(product);
            return ResponseEntity.ok("New Product Added");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        try{
            String updateResult = productService.updateProduct(product);
            return ResponseEntity.ok(updateResult);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<String> deleteProduct(@RequestBody long id){
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()){
            productService.removeProduct(id);
            return ResponseEntity.ok("Product Removed");
        }else{
            return ResponseEntity.internalServerError().body("Product Does Not Exist");
        }
    }

    @GetMapping("/findByCategory")
    public ResponseEntity<List> findByCategory(@RequestBody String category){
        List<Product> productList = productService.findByCategory(category);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/getCategories")
    public ResponseEntity<List> getCategories(){
        List<String> distinctCategories = productService.findDistinctCategories();
        return ResponseEntity.ok(distinctCategories);
    }
}
