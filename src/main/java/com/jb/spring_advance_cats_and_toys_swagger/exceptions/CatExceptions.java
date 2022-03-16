package com.jb.spring_advance_cats_and_toys_swagger.exceptions;

public class CatExceptions extends Exception{
    public CatExceptions() {
        super("Cat exception!!");
    }

    public CatExceptions(String message) {
        super(message);
    }
}
