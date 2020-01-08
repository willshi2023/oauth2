package com.example.oauth2demo.exception;

import lombok.Data;

@Data
public class UserNotExistException extends RuntimeException {
    private String id;
    public UserNotExistException(String id){
        super("user not exist");
        this.id = id;
    }
}
