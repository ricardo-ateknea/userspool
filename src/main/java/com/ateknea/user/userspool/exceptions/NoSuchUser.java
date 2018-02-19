package com.ateknea.user.userspool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such User")
public class NoSuchUser extends RuntimeException {
    public NoSuchUser(String s) {

    }
}
