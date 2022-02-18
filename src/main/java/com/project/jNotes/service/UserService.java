package com.project.jNotes.service;

import com.project.jNotes.domens.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String email);

    User findByEmail(String email);

    void save(User user);

    User getCurrentUser();
}
