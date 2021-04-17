package fr.library.emprunt.service.impl;


import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class MailServiceImpl implements MailService {


    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("golloumette59@gmail.com");
        message.setTo("caroline.boucau59@gmail.com");
        message.setSubject("Test Simple Email");
        message.setText("Test mail");
        emailSender.send(message);
    }

    public void relanceMail(ReservationEntity reservationEntity) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("golloumette59@gmail.com");
        message.setTo(reservationEntity.getUsagerEntity().getMail());
        message.setSubject("Relance de votre réservation");
        message.setText("Test mail de relance ");
        emailSender.send(message);

    }


}
