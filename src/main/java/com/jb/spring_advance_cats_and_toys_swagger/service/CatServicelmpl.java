package com.jb.spring_advance_cats_and_toys_swagger.service;

import com.jb.spring_advance_cats_and_toys_swagger.beans.Cat;
import com.jb.spring_advance_cats_and_toys_swagger.exceptions.CatExceptions;

import java.util.List;
import java.util.function.Predicate;

public interface CatServicelmpl {
    public void saveCat(Cat cat);

    public void updateCat(Cat cat) throws CatExceptions;

    public void deleteCat(int id) throws CatExceptions;

    public List<Cat> getAllCats();

    public Cat getCatById(int id) throws CatExceptions;

    public List<Cat> getAllOrderByNameAndWeight() throws CatExceptions;

    public Predicate<Cat> isWeightValid = weight -> weight.getWeight() < 0;
}
