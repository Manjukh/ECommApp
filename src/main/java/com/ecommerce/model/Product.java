package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long productId;
    @Column
    private String productName;
    private String productDescription;
    private long productPrice;

    @Builder
    public Product(long productId,String productName,String productDescription, long productPrice){

        this.productId=productId;
        this.productName=productName;
        this.productDescription=productDescription;
        this.productPrice=productPrice;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Cart cart;


}
