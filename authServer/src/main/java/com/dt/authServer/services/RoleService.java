package com.dt.authServer.services;

import com.dt.authServer.entities.Role;
import com.dt.authServer.repos.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role findRole(String role){
        return roleRepo.findByRole(role);
    }
}
