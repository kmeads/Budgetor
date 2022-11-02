package com.budgetor.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.budgetor.Models.User;

/* 
 * This repo will be auto implemented by a spring bean called userRepository 
 * CRUD refers to Create, Read, Update, Delete
 * 
 */

public interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email : String) : User?; // auto-magic function that must be 'findBy[your parameter]'. >:(
}