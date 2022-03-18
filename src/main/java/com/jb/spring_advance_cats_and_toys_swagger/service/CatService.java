package com.jb.spring_advance_cats_and_toys_swagger.service;

import com.jb.spring_advance_cats_and_toys_swagger.beans.Cat;
import com.jb.spring_advance_cats_and_toys_swagger.exceptions.CatExceptions;
import com.jb.spring_advance_cats_and_toys_swagger.repo.CatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatService implements CatServicelmpl {
    private final CatRepo catRepo;

    @Override
    public void saveCat(Cat cat) {
        catRepo.save(cat);
    }

    @Override
    public void updateCat(Cat cat) throws CatExceptions {
        if (catRepo.existsById(cat.getId())) {
            catRepo.save(cat);
        } else {
            throw new CatExceptions("Cat not found");
        }
    }

    @Override
    public void deleteCat(int id) throws CatExceptions {
        if (catRepo.existsById(id)) {
            catRepo.deleteById(id);
        } else {
            throw new CatExceptions("Cat not found");
        }
    }

    @Override
    public Cat getCatById(int id) throws CatExceptions {
        if (catRepo.existsById(id)) {
            return catRepo.findById(id).get();
        } else {
            throw new CatExceptions("Cat not found");
        }
    }

    @Override
    public List<Cat> getAllCats() {
        return catRepo.findAll();
    }

    @Override
    public List<Cat> getAllOrderByNameAndWeight() throws CatExceptions {
        try {
            if (isWeightValid.test((Cat) catRepo.findAll())) {
                return catRepo.findAllOrderByNameAndWeight();
            }else {
                throw new CatExceptions("Invalid weight");
            }
        }catch (CatExceptions catExceptions){
            System.out.println(catExceptions.getMessage());
            return null;
        }
    }

}
