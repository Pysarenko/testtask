package com.portaone.testtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TesttaskApplication {

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        SpringApplication.run(TesttaskApplication.class, args);

        System.out.println("Max: " + FileActions.findMax());
        System.out.println("Min: " + FileActions.findMin());
        System.out.println("Median: " + FileActions.median());
        System.out.println("Average: " + FileActions.average());
        System.out.println("The largest increase sequence: " + FileActions.increaseSequence());
        System.out.println("The largest decrease sequence: " + FileActions.decreaseSequence());

        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime)/1000000000 + "sec");
    }
}
