package com.ateknea.user.userspool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Invalid e-mail field")
public class InvalidEmail extends RuntimeException {
    public InvalidEmail(String s) {
    }
}
