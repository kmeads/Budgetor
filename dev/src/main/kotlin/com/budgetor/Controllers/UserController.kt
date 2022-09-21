package com.budgetor.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus
import com.budgetor.Models.User

@RestController
@RequestMapping("/api/user")
class UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody user : User) : User {
        println("\n\nWorked\n\n");
        return user;
    }
}