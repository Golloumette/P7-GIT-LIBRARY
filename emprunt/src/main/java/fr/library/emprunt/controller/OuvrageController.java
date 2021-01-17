package fr.library.emprunt.controller;

import fr.library.emprunt.service.OuvrageService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OuvrageController {
    private final OuvrageService ouvrageService;

    public OuvrageController(OuvrageService ouvrageService) {
        this.ouvrageService = ouvrageService;
    }
}
