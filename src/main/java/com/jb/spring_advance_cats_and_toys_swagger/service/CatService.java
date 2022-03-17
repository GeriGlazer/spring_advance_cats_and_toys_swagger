package com.jb.spring_advance_cats_and_toys_swagger.service;

import com.jb.spring_advance_cats_and_toys_swagger.beans.Cat;
import com.jb.spring_advance_cats_and_toys_swagger.exceptions.CatExceptions;
import com.jb.spring_advance_cats_and_toys_swagger.repo.CatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
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
    public List<Cat> getAllCatsByNameAndWeight() throws CatExceptions {
        //todo: throw new CatExceptions("Invalid weight");
        //List<Cat> catList = catRepo.findAll();
        Comparator<Cat> compareNamesAndWeight = Comparator
                .comparing(Cat::getName)
                .thenComparing(Cat::getWeight);

        return catRepo.findAll().stream().sorted(compareNamesAndWeight).collect(Collectors.toList());

//        return catList.stream()
//                .sorted(compareNamesAndWeight)
//                .collect(Collectors.toList());
    }

}
