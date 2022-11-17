package com.budgetor.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import com.sun.mail.iap.Response;

import com.budgetor.Models.User;

@Controller
@RequestMapping("/")
public class LandingController {
    @GetMapping()
    fun index() : String = "landingFragments/landingPg";

    @GetMapping("about")
    fun about() : String = "landingFragments/about";

    @GetMapping("app")
    fun app() : String = "landingFragments/app";

    @GetMapping("contact")
    fun contact() : String = "landingFragments/contact";

    @GetMapping("signUp")
    fun signUp() : String = "auxiliary/signUp";

    @GetMapping("login")
    fun login() : String = "auxiliary/login";

    @GetMapping("privacy")
    fun privacy() : String = "auxiliary/privacy";
}