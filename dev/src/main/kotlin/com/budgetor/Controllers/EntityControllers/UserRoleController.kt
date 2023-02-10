package com.budgetor.Controllers.EntityControllers;

import com.budgetor.Models.UserRole;
import com.budgetor.Repositories.UserRoleRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize

@RestController
@RequestMapping("/api/user/user_role")
class UserRoleController(private val repository : UserRoleRepository) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('USER')")
    fun addUserRole(@RequestBody role : UserRole) : UserRole {
        repository.save(role);
        return role;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    fun getUserRoles() : Iterable<UserRole> {
        return repository.findAll();
    }
}