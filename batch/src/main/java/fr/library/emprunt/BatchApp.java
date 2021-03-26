package fr.library.emprunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BatchApp {
    public static void main(String[] args) {
        SpringApplication.run(BatchApp.class, args);
    }
}
