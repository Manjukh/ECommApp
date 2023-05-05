package com.ecommerce.Repository;

import com.ecommerce.model.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    @Query("FROM Product WHERE productDescription= :productDescription")
    List<Product> findProductByProductDescription(@Param("productDescription") String productDescription);

    @Query("FROM Product WHERE LOWER(productName) LIKE %:productName%")
    List<Product> findProductByProductName(@Param("productName") String productName);


}
