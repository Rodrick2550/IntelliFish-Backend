package com.example.intellifishbackend.controllers.advices;

import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.controllers.exceptions.AccessDeniedException;
import com.example.intellifishbackend.controllers.exceptions.ObjectNotFoundException;
import com.example.intellifishbackend.controllers.exceptions.UniqueConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(UniqueConstraintViolationException.class)
    public ResponseEntity<BaseResponse> handleuUniqueConstraintViolationExceptionResponseEntity
            (UniqueConstraintViolationException exception){

        Map<String,String> errors = new HashMap<>();

        String message = exception.getMessage();

        errors.put("message: ", message);

        return BaseResponse.builder()
                .data(errors)
                .message("Operation failed")
                .success(Boolean.FALSE)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build().apply();
    }
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<BaseResponse> handleObjectNotFoundException(ObjectNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();

        String message = ex.getMessage();

        errors.put("message", message);

        return BaseResponse.builder()
                .data(errors)
                .message("Operation failed")
                .success(Boolean.FALSE)
                .status(HttpStatus.NOT_FOUND)
                .build().apply();
    }
}
