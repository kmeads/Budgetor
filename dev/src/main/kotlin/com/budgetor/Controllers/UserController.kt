package com.budgetor.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired
import com.budgetor.Models.User;
import com.budgetor.Repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
class UserController(private val repository : UserRepository) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody user : User) : User {
        repository.save(user);
        return user;
    }
    
    @GetMapping("/{user}")
    fun getUser (
        @PathVariable email : String,
        @PathVariable password : String
    ) : String {
        val user = repository.findByEmail(email) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");

        return user.email;
    }
}