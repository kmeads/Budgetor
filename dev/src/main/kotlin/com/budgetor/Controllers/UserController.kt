package com.budgetor.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.boot.web.server.Cookie
import com.budgetor.Models.User;
import com.budgetor.config.Message;
import com.budgetor.Repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

@RestController
@RequestMapping("/api/user")
class UserController(private val repository : UserRepository) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody user : User) : User {
        repository.save(user);
        return user;
    }
    
    @GetMapping
    @ResponseBody
    fun getUser (
        @RequestParam email : String,
        @RequestParam password : String
    ) : ResponseEntity<Any> {
        val user : User = repository.findByEmail(email) ?: return ResponseEntity.badRequest().body(Message("User does not exist"));
        
        //authenticate
        if(!user.authenticate(password)) 
            return ResponseEntity.badRequest().body(Message("User cannot be authenticated"));
        
        return ResponseEntity.ok(user);
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/all")
    fun getAllUsers() : Iterable<User> {
        return repository.findAll();
    }
}