package com.ecommerce.controller;

import com.ecommerce.Exceptions.UserServiceException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.model.UserAccount;
import com.ecommerce.service.CartService;
import com.ecommerce.service.UserAccountService;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class EcommController {


    @Autowired
     ProductService productService;
    @Autowired
     CartService cartService;
    @Autowired
     UserAccountService userAccountService;
     @Autowired

     public EcommController(ProductService productService,CartService cartService,UserAccountService userAccountService){
         this.productService= productService;
         this.cartService=cartService;
         this.userAccountService= userAccountService;
     }






    @PostMapping("register")
    public UserAccount register(@RequestBody UserAccount account) throws UserServiceException {
        return userAccountService.addAccount(account);
    }

    @PostMapping("login")
    public ResponseEntity<Map<String, String>> login(@RequestBody @NonNull UserAccount account){
        UserAccount exist = userAccountService.existingAccount(account.getUsername(), account.getPassword());
        if(exist != null){
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful.");
            return ResponseEntity.ok().body(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Invalid username or password.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    @PostMapping("/addNewProduct")
    public Product addNewProduct(@RequestBody Product product){

        return productService.addNewProduct(product);
    }


    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }



    @DeleteMapping("/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
     productService.deleteProduct(productId);

    }

    @PostMapping("/addToCart/{productId}")

    public Cart addToCart(@PathVariable(name="productId") long productId){


        return cartService.addToCart(productId);
    }


    @GetMapping("/allCarts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }


}
