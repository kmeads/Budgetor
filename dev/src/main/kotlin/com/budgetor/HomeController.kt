package com.budgetor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @GetMapping("/")
    fun index() : String {
        return "landingFragments/landingPg";
    }

    @GetMapping("/about")
    fun about() : String {
        return "landingFragments/about";
    }

    @GetMapping("/app")
    fun app() : String {
        return "landingFragments/app";
    }

    @GetMapping("/contact")
    fun contact() : String {
        return "landingFragments/contact";
    }

    @GetMapping("/signUp")
    fun signUp() : String {
        return "landingFragments/signUp";
    }

    @GetMapping("/error")
    fun error() : String {
        return "error";
    }
}