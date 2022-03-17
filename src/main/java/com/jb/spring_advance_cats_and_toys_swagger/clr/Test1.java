package com.jb.spring_advance_cats_and_toys_swagger.clr;

import com.jb.spring_advance_cats_and_toys_swagger.beans.Cat;
import com.jb.spring_advance_cats_and_toys_swagger.beans.Toy;
import com.jb.spring_advance_cats_and_toys_swagger.repo.CatRepo;
import com.jb.spring_advance_cats_and_toys_swagger.repo.ToyRepo;
import com.jb.spring_advance_cats_and_toys_swagger.service.CatService;
import com.jb.spring_advance_cats_and_toys_swagger.util.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@Order(1)
@RequiredArgsConstructor
public class Test1 implements CommandLineRunner {
    private final CatRepo catRepo;
    private final ToyRepo toyRepo;
    private final CatService catService;


    @Override
    public void run(String... args) throws Exception {

        Cat cat1 = Cat.builder()
                .name("snowflake")
                .weight(10.3F)
                .build();

        Cat cat2 = Cat.builder()
                .name("daemon")
                .weight(8.5F)
                .build();

        Cat cat3 = Cat.builder()
                .name("sprinkles")
                .weight(12F)
                .build();

        Cat cat4 = Cat.builder()
                .name("rusty")
                .weight(6F)
                .build();

        List<Cat> catList = List.of(cat1, cat2, cat3, cat4);
        //catRepo.saveAll(catList);

        Toy toy1 = Toy.builder()
                .name("rubber_Fish")
                .build();

        Toy toy2 = Toy.builder()
                .name("mouse_on_a_stick")
                .build();

        Toy toy3 = Toy.builder()
                .name("tree_trunk")
                .build();
        Toy toy4 = Toy.builder()
                .name("light_post")
                .build();
        Toy toy5 = Toy.builder()
                .name("fur_ball")
                .build();
        List<Toy> toyList = List.of(toy1, toy2, toy3, toy4, toy5);
        //toyRepo.saveAll(toyList);

        if (!catRepo.findAll().isEmpty()) {
            System.out.println("Cats saved");
        } else {
            //custom exception (advice)
            System.out.println("Fail to add cat/s");
        }

        /*Cat snowFlake = catRepo.getById(1);
        snowFlake.setToyList(List.of(toy1, toy3));
        catRepo.save(snowFlake);

        Cat daemon = catRepo.getById(2);
        daemon.setToyList(List.of(toy2, toy4, toy5));
        catRepo.save(daemon);

        Cat sprinkles = catRepo.getById(3);
        sprinkles.setToyList(List.of(toy1, toy2,toy3, toy4,toy5));
        catRepo.save(sprinkles);

        Cat rusty = catRepo.getById(4);
        rusty.setToyList(List.of(toy1, toy2, toy5));
        catRepo.save(rusty);

*/
//todo: it saves the toys again producing new id numbers
        /*
        catRepo.findById(1).ifPresentOrElse(
                cat -> {
                    cat.setToyList(List.of(toy1, toy3));
                    catRepo.save(cat1);
                    System.out.println("toys saved for cat1");
                }, () -> System.out.println("cat not found"));
        //todo: instead of using toys 2 and 3 already in db it creates a copy of them (id= 5 & 6 )
        catRepo.findById(2).ifPresentOrElse(
                cat -> {
                    cat.setToyList(List.of(toy2, toy3, toy5));
                    catRepo.save(cat2);
                    System.out.println("toys saved for cat2");
                }, () -> System.out.println("Cat Not found"));

        catRepo.findById(3).ifPresentOrElse(
                cat -> {
                    cat.setToyList(List.of(toy1, toy5));
                    catRepo.save(cat3);
                    System.out.println("toys saved for cat3");
                }, () -> System.out.println("Cat Not found"));

        catRepo.findById(4).ifPresentOrElse(
                cat -> {
                    cat.setToyList(List.of(toy4, toy2, toy1, toy5));
                    catRepo.save(cat4);
                    System.out.println("toys saved for cat4");
                }, () -> System.out.println("Cat Not found"));



        if (catRepo.existsById(2)) {
            catRepo.deleteById(2);
            System.out.println("deleted");
        } else {
            //custom Exception (advice)
            System.out.println("Cat Not found");
        }



        if (catRepo.existsById(4)) {
            System.out.println(catRepo.getById(4));
        } else {
            //custom Exception (advice)
            System.out.println("Cat Not found");
        }

        if (!catRepo.findAll().isEmpty()) {
            catList = catRepo.findAll();
            TablePrinter.print(catList);
        } else {
            //custom Exception (advice)
            System.out.println("No cats in database");
        }*/
        TablePrinter.print(catService.getAllCatsByNameAndWeight());

    }
}
