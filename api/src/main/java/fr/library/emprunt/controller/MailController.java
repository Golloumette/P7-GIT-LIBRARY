package fr.library.emprunt.controller;


import fr.library.emprunt.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {



    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }



    // methode pour envoyer un mail
    @ResponseBody
    @RequestMapping("/mail/")
    public String envoieMail(){

         return mailService.sendMail();
    }
}
