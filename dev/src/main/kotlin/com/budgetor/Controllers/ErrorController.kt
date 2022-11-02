package com.budgetor.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;

@Controller
public class _ErrorController : ErrorController {

    @RequestMapping("/error")
    fun handleError(
        request : HttpServletRequest,
        model : Model
    ) : String {
        model.addAttribute("statusCode", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        model.addAttribute("message", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        return "error";
    }
}