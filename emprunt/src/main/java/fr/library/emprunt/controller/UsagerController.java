package fr.library.emprunt.controller;


import fr.library.emprunt.dto.UsagerDTO;
import fr.library.emprunt.mapper.UsagerMapper;
import fr.library.emprunt.model.UsagerEntity;
import fr.library.emprunt.service.UsagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("usagers")
public class UsagerController {
    private final UsagerService usagerService;
    private final UsagerMapper usagerMapper;

    public UsagerController(UsagerService usagerService, UsagerMapper usagerMapper) {

        this.usagerService = usagerService;
        this.usagerMapper = usagerMapper;
    }
    @GetMapping("/")
    public List<UsagerDTO> getAll (){
        List<UsagerEntity> usagers = usagerService.findAll();
        List<UsagerDTO> usagerDTOS = usagerMapper.toDTOs(usagers);

        return usagerDTOS;
    }
}
