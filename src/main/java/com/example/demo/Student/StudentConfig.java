package com.example.demo.Student;

import java.time.LocalDate;
import java.util.Arrays;

import static java.time.Month.JANUARY;
import static java.time.Month.JUNE;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student chetan = new Student(
                        "Chetan",
                        "chetan@gmail.con",
                        LocalDate.of(1988, JANUARY, 5));
            
            Student sameer = new Student(
                        "Sameer",
                        "chetan@gmail.con",
                        LocalDate.of(1989, JUNE, 5));
            
            repository.saveAll(Arrays.asList(chetan, sameer));
        };
    }
}
