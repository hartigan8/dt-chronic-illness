package com.dt.authServer.repos;

import com.dt.authServer.entities.Role;
import com.dt.authServer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    public Role findByRole(String Role);
}
