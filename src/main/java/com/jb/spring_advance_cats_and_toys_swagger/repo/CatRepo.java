package com.jb.spring_advance_cats_and_toys_swagger.repo;

import com.jb.spring_advance_cats_and_toys_swagger.beans.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//@Component
public interface CatRepo extends JpaRepository<Cat, Integer> {

    Predicate<Cat> isWeightValid = weight -> weight.getWeight() < 0;

    //List<Cat> findByNameAndWeight(String name, Float weight);

    List<Cat> findAllOrderByNameAndWeight();
    //List<Cat> findByNameOrWeight(String name, Float weight);
    List<Cat> findAllOrderByNameOrWeight();

    List<Cat> findAllOrderByWeightAsc();
    List<Cat> findAllOrderByWeightDesc();

    List<Cat> findByNameStartingWith(char letter);


}
