package com.example.rewards.controller;
/*
 * Customize the error page
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@RestController
public class AppErrorController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                    return "Error: This Page Can Not Be Found. Please Try http://localhost:8080/customers/{customerId}";
                }
            
            if(statusCode == HttpStatus.FORBIDDEN.value()) {
                    return "Error: Invalid / Missing Customer Id.";
                }        
        }
        return "Oops, Something Went Wrong. Please Try Again.";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}



















