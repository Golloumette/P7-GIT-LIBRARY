package fr.library.emprunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EmpruntApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmpruntApplication.class, args);

    }

}
