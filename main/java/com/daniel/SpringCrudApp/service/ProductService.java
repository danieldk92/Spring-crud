package com.daniel.SpringCrudApp.service;

import com.daniel.SpringCrudApp.entity.Product;
import com.daniel.SpringCrudApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    ProductRepository repo;

    @Autowired
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts(){
       return repo.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return repo.findById(id);
    }

    public Product saveProduct(Product product){
       return repo.save(product);
    }

    public void deleteProductById(Long id){
        repo.deleteById(id);
    }

    public void updateProductById(Product product, Long id){
        Product exists = repo.findById(id).get();
        exists.setName(product.getName());
        exists.setPrice(product.getPrice());
        repo.save(exists);
    }
}
