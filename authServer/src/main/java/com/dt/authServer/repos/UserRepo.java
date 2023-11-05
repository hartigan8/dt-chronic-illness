package com.dt.authServer.repos;

import com.dt.authServer.entities.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Id> {
}
