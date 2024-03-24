package com.bookManagement.service.exception;

public class AuthenticationFailedException extends RuntimeException {
    public AuthenticationFailedException() {
        super("Authentication failed. Username or password is incorrect.");
    }
}
