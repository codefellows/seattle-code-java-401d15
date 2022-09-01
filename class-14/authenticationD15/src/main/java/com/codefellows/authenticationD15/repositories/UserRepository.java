package com.codefellows.authenticationD15.repositories;

import com.codefellows.authenticationD15.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

    // CUSTOM CRUD QUERIES
    SiteUser findByUsername(String username);
}
