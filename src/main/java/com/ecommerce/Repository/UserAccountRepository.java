package com.ecommerce.Repository;

import com.ecommerce.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    @Query("FROM UserAccount WHERE username = :username")
    Optional<UserAccount> getUserByName(@Param("username") String username);

    public UserAccount findByEmail(@Param("email") String email);
}
