package com.jb.spring_advance_cats_and_toys_swagger.repo;

import com.jb.spring_advance_cats_and_toys_swagger.beans.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepo extends JpaRepository<Toy, Integer> {
}
