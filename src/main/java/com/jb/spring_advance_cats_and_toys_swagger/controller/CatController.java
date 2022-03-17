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
    public ResponseEntity<?> getAllCats() {
       return new ResponseEntity<>(catService.getAllCats(), HttpStatus.OK);
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> getCatById(@PathVariable int id) throws CatExceptions {
        try {
            return new ResponseEntity<>(catService.getCatById(id), HttpStatus.ACCEPTED);
        } catch (CatExceptions e) {
            System.out.println(e.getMessage());
            throw new CatExceptions(e.getMessage());
        }
    }

//    @PostMapping("/add")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public void saveNewCat(@RequestBody Cat cat){
//        catService.saveCat(cat);
//    }

    @PostMapping("/add")
    public ResponseEntity<?> newCat (@RequestBody Cat cat){
        catService.saveCat(cat);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
    public ResponseEntity<?> getAllCatsByNameAndWeight() throws CatExceptions {
        return new ResponseEntity<>(catService.getAllCatsByNameAndWeight(), HttpStatus.OK);
    }


}
