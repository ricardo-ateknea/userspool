package com.ateknea.user.userspool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Field exceeds the limit of characters")
public class TooMuchCharacters extends RuntimeException {
    public TooMuchCharacters(String s) {

    }
}
