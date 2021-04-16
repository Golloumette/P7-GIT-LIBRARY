package fr.library.emprunt.service.impl;

import fr.library.emprunt.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class MailServiceImpl implements MailService {

    @Autowired
    public JavaMailSender emailSender;

    public String sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("caroline.boucau59@gmail.com");
        message.setSubject("Test Simple Email");
        message.setText("Test mail");

        this.emailSender.send(message);

        return "email envoyé";
    }
}
