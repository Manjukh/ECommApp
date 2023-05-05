package com.ecommerce.service;

import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {




     ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product addNewProduct(Product product)  {

        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }



    public Product getProductByProductId(long productId){

        Optional<Product> productOptional = productRepository.findById(productId);

        Product product= productOptional.get();
        return product;
    }

    public List<Product> getProductByName(String productName){
        return productRepository.findProductByProductName(productName);
    }
}
