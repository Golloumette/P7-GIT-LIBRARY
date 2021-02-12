package fr.library.emprunt.controller;


import fr.library.emprunt.dto.UsagerDTO;
import fr.library.emprunt.service.UsagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("usager")
public class UsagerController {
    private final UsagerService usagerService;

    public UsagerController(UsagerService usagerService) {

        this.usagerService = usagerService;
    }
    @GetMapping("/")
    public List<UsagerDTO> getAll (){

        return Collections.emptyList();
    }
}
