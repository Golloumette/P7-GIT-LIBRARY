package fr.library.emprunt.controller;


import fr.library.emprunt.service.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {


    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }


    @ResponseBody
    @GetMapping("/mail")
    public String envoieMail() {
        mailService.sendSimpleMessage();
        return "ok";
    }
}
