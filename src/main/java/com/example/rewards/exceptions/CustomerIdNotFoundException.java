package com.example.rewards.exceptions;
/*
 * Define a CustomerIdNotFoundException
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Invalid / Missing Customer Id")
public class CustomerIdNotFoundException extends RuntimeException{
    
}
