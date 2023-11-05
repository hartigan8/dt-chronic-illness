package com.dt.authServer.services;

import com.dt.authServer.entities.User;
import com.dt.authServer.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User save(User user){
        return userRepo.save(user);
    }


    public User getOneUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow();
    }
}
