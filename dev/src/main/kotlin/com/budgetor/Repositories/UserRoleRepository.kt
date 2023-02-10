package com.budgetor.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.budgetor.Models.UserRole;

/* 
 * This repo will be auto implemented by a spring bean called userRepository 
 * CRUD refers to Create, Read, Update, Delete
 * 
 */

public interface UserRoleRepository : JpaRepository<UserRole, Long> {
    fun findById(id : String) : UserRole?;
}