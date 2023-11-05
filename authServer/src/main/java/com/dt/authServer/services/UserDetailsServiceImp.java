package com.dt.authServer.services;

import com.dt.authServer.entities.User;
import com.dt.authServer.repos.UserRepo;
import com.dt.authServer.security.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepo.findByEmail(username);
        if(userOptional.isPresent()){
            return UserDetailsImp.create(userOptional.get());
        }
        return null;
    }
    public UserDetails loadUserById(Long id){
        return UserDetailsImp.create(userRepo.findById(id).get());
    }
}
