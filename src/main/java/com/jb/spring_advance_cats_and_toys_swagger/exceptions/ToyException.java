package com.jb.spring_advance_cats_and_toys_swagger.exceptions;

public class ToyException extends Exception{
    public ToyException() {
        super("Toy exception!!");
    }

    public ToyException(String message) {
        super(message);
    }
}
