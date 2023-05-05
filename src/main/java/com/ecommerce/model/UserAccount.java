package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class UserAccount {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long userid;
    private String name;
    private String username;
    private String email;
    private String password;

}
