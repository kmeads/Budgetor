package com.budgetor.service;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.budgetor.Repositories.UserRepository;
import com.budgetor.Models.User;
import com.budgetor.Models.SecurityUser;

@Service
class JpaUserDetailsService(private val userRepo : UserRepository) : UserDetailsService {
    override fun loadUserByUsername(email : String) : UserDetails = SecurityUser(userRepo.findByEmail(email) ?: throw UsernameNotFoundException("The user with email '$email'"));
}