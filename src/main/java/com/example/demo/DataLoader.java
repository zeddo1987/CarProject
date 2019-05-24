package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    carRepository repository;
    @Override
    public void run(String... strings) throws Exception{
        Cars car = new Cars("2019","Toyota", "T6464M2019");
        repository.save(car);

        Cars car = new Cars("2018", "Nissan", "N6464M2020");
        repository.save(car);

        Cars car = new Cars("2020", "Lexux", "L2020M6464");
        repository.save(car);
    }
}
