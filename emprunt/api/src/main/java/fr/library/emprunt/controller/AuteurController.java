package fr.library.emprunt.controller;


import fr.library.emprunt.dto.AuteurDTO;
import fr.library.emprunt.mapper.AuteurMapper;
import fr.library.emprunt.model.AuteurEntity;
import fr.library.emprunt.service.AuteurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("auteurs")
public class AuteurController {
    private final AuteurService auteurService;
    private final AuteurMapper auteurMapper;

    public AuteurController(AuteurService auteurService, AuteurMapper auteurMapper) {
        this.auteurService = auteurService;
        this.auteurMapper = auteurMapper;
    }

    @GetMapping("/")
    public List<AuteurDTO> getAll() {
        List<AuteurEntity> auteurs = auteurService.findAll();
        List<AuteurDTO> auteurDTOS = auteurMapper.toDTOs(auteurs);
        return auteurDTOS;
    }

}
