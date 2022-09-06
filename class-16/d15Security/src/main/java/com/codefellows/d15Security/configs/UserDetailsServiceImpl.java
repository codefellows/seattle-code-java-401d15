package com.codefellows.d15Security.configs;

import com.codefellows.d15Security.repositories.SiteUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// TODO: Step 3: Make a UserDetailsServiceImpl that implements UserDetailsService
// Don't forget @Service anno
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SiteUserRepo siteUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) siteUserRepo.findByUsername(username);
    }
}
