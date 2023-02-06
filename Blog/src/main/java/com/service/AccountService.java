package com.service;

import com.model.Account;
import com.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    IAccountRepo iAccountRepo;
    public Account checkLogin(String username, String password){
        return iAccountRepo.checkLogin(username,password);
    }

    public void register(Account account) {
        iAccountRepo.save(account);
    }
}
