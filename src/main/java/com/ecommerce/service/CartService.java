package com.ecommerce.service;

import com.ecommerce.Repository.CartRepository;
import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }



    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart addToCart(long productId) {


        Product products= productService.getProductByProductId(productId);
        Cart cart = new Cart(products);

        if (products == null) {
            return null;
        } else

            return cartRepository.save(cart);
    }

}
