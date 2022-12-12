package com.budgetor.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.prepost.PreAuthorize

@Controller
@RequestMapping("/home")
public class HomeController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping()
    fun current() : String = "homeFragments/home.html";

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/bigPicture")
    fun bigPicture() : String = "homeFragments/bigPicture.html";

}
