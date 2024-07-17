package com.example.digitalchieftesttask.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SameNameException extends ResponseStatusException {
    public SameNameException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public SameNameException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
