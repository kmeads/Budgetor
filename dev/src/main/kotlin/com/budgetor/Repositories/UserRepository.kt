package com.budgetor.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.budgetor.Models.User;

/* This repo will be auto implemented by a spring bean called userRepository 
 * CRUD refers to Create, Read, Update, Delete
*/

public interface UserRepository : CrudRepository<User, Int> {
    fun findByEmail(email : String) : User?; // auto-magic function that must be 'findBy[your parameter]'. >:(
}