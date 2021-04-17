package fr.library.emprunt.controller;


import fr.library.emprunt.dto.PersonnelDTO;
import fr.library.emprunt.mapper.PersonnelMapper;
import fr.library.emprunt.model.PersonnelEntity;
import fr.library.emprunt.service.PersonnelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personnels")
public class PersonnelController {
    private final PersonnelService personnelService;
    private final PersonnelMapper personnelMapper;

    public PersonnelController(PersonnelService personnelService, PersonnelMapper personnelMapper) {

        this.personnelService = personnelService;
        this.personnelMapper = personnelMapper;
    }

    @GetMapping("/")
    public List<PersonnelDTO> getAll() {
        List<PersonnelEntity> personnels = personnelService.findAll();
        List<PersonnelDTO> personnelDTOS = personnelMapper.toDTOs(personnels);
        return personnelDTOS;
    }
}
