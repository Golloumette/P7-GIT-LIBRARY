package fr.library.emprunt.controller;

import fr.library.emprunt.model.OuvrageEntity;
import fr.library.emprunt.service.OuvrageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ouvrages")
public class OuvrageController {
    private final OuvrageService ouvrageService;

    public OuvrageController(OuvrageService ouvrageService) {
        this.ouvrageService = ouvrageService;
    }

    @GetMapping("/")
    public List<OuvrageEntity> getAll() {
        return ouvrageService.findAll();
    }
}
