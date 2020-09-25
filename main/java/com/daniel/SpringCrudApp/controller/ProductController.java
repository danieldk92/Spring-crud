package com.daniel.SpringCrudApp.controller;

import com.daniel.SpringCrudApp.entity.Product;
import com.daniel.SpringCrudApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String getHello(){
        return "Hello friend";
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PutMapping("/update/{id}")
    public void updateProductById(@PathVariable Long id, @RequestBody Product product){
        productService.updateProductById(product,id);
    }
}
