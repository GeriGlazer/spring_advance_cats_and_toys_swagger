package com.jb.spring_advance_cats_and_toys_swagger.clr;

import com.jb.spring_advance_cats_and_toys_swagger.repo.CatRepo;
import com.jb.spring_advance_cats_and_toys_swagger.repo.ToyRepo;
import com.jb.spring_advance_cats_and_toys_swagger.util.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(2)
@RequiredArgsConstructor
public class Test2 implements CommandLineRunner {
    private final CatRepo catRepo;
    //private final ToyRepo toyRepo;

    @Override
    public void run(String... args) throws Exception {
       // catRepo.findByNameAndWeight("daemon", 8.5F);
        //catRepo.findByNameAndWeight("daemon", 8.5F).forEach(System.out::println);
        TablePrinter.print(catRepo.findByNameAndWeight("daemon", 8.5f));
        TablePrinter.print(catRepo.findByNameOrWeight("sprinkles", 12f));
        //TablePrinter.print(catRepo.getAllByWeightAsc());
        //TablePrinter.print(catRepo.getByNameOrderByWeightDesc());
        TablePrinter.print(catRepo.findByNameStartingWith('s'));
    }
}
