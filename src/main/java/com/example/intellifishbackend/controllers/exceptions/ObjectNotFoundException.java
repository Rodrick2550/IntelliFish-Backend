package com.example.intellifishbackend.controllers.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String message){

        super(message);
    }
}
