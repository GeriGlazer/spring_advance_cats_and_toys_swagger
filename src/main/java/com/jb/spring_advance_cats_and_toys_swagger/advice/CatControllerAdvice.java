package com.jb.spring_advance_cats_and_toys_swagger.advice;

import com.jb.spring_advance_cats_and_toys_swagger.exceptions.CatExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CatControllerAdvice {
    @ExceptionHandler (value = {CatExceptions.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDetail handleCatException(Exception ex){
        return new ErrorDetail("Cat Error", ex.getMessage());
    }
}
