package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long cartId;
    @OneToOne

    private Product products;

  //  @OneToOne
   // private UserAccount userAccount;



    public Cart(Product products){
        this.products=products;
    }
}
