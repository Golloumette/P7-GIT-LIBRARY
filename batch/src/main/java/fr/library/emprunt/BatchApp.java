package fr.library.emprunt;

import fr.library.emprunt.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BatchApp {
    @Autowired
    MailServiceImpl mailService;


    public static void main(String[] args) {

        SpringApplication.run(BatchApp.class, args);

    }
}
