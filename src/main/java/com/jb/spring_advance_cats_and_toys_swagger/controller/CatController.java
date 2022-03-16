package com.jb.spring_advance_cats_and_toys_swagger.controller;

import com.jb.spring_advance_cats_and_toys_swagger.beans.Cat;
import com.jb.spring_advance_cats_and_toys_swagger.exceptions.CatExceptions;
import com.jb.spring_advance_cats_and_toys_swagger.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cat")
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public void getAllCats() {
       catService.getAllCats();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void getCatById(@PathVariable int id) throws CatExceptions {
        try {
            catService.getCatById(id);
        } catch (CatExceptions e) {
            System.out.println(e.getMessage());
            throw new CatExceptions(e.getMessage());
        }
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveNewCat(@RequestBody Cat cat){
        catService.saveCat(cat);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateCat(@RequestBody Cat cat) throws CatExceptions {
        catService.updateCat(cat);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteCat(@PathVariable int id) throws CatExceptions {
        catService.deleteCat(id);
    }

    @GetMapping("/allbynameandweight")
    @ResponseStatus(code = HttpStatus.OK)
    public void getAllCatsByNameAndWeight() throws CatExceptions {
        catService.getAllCatsByNameAndWeight();
    }


}
