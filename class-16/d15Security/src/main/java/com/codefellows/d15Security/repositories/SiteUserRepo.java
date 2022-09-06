package com.codefellows.d15Security.repositories;

import com.codefellows.d15Security.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO: Step1B: Make user repository (INTERFACE!!!!)
public interface SiteUserRepo extends JpaRepository<SiteUser, Long> {
    SiteUser findByUsername(String username);
}
