package com.ecommerce.service;

import com.ecommerce.Exceptions.UserServiceException;
import com.ecommerce.Repository.UserAccountRepository;
import com.ecommerce.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

import java.util.Optional;




@Service

public class UserAccountService {


   UserAccountRepository  userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository= userAccountRepository;
    }

    // new registration
    public UserAccount addAccount(UserAccount userAccount) throws UserServiceException {
        if (userAccountRepository.findByEmail(userAccount.getEmail()) != null)
throw new UserServiceException("USER_ALREADY_EXISTS");
        if (userAccount.getUsername() != "" && userAccount.getPassword().length() >= 4) {
            Optional<UserAccount> optionalUser = userAccountRepository.getUserByName(userAccount.getUsername());
            if(optionalUser.isEmpty()){
                userAccountRepository.save(userAccount);
                return userAccount;
            }
        }
        return null;
    }


    // login with existing account
    public UserAccount existingAccount(String username, String password) {
        Optional<UserAccount> optionalUser = userAccountRepository.getUserByName(username);
        if(optionalUser.isEmpty()){
            return null;
        }
        UserAccount existing = optionalUser.get();
        if (Objects.equals(existing.getPassword(), password))
            return existing;
        else
            return null;
    }
}
