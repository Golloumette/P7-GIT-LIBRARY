package fr.library.emprunt.controller;


import fr.library.emprunt.model.PersonnelEntity;
import fr.library.emprunt.service.PersonnelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("personnel")
public class PersonnelController {
    private final PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {

        this.personnelService = personnelService;
    }

    @GetMapping("/liste")
    public List<PersonnelEntity> getAll(){
        List<PersonnelEntity> all = personnelService.findAll();
        return Arrays.asList();
    }
}
