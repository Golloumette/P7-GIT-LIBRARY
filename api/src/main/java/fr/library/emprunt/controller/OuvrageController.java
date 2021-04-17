package fr.library.emprunt.controller;

import fr.library.emprunt.dto.OuvrageDTO;
import fr.library.emprunt.mapper.OuvrageMapper;
import fr.library.emprunt.model.OuvrageEntity;
import fr.library.emprunt.service.OuvrageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ouvrages")
public class OuvrageController {
    private final OuvrageService ouvrageService;
    private final OuvrageMapper ouvrageMapper;

    public OuvrageController(OuvrageService ouvrageService, OuvrageMapper ouvrageMapper) {

        this.ouvrageService = ouvrageService;
        this.ouvrageMapper = ouvrageMapper;
    }

    @GetMapping("/")
    public List<OuvrageDTO> getAll() {
        List<OuvrageEntity> ouvrages = ouvrageService.findAll();
        List<OuvrageDTO> ouvrageDTOS = ouvrageMapper.toDTOs(ouvrages);
        return ouvrageDTOS;
    }

    @GetMapping("/{search}")
    public List<OuvrageDTO> search(@PathVariable("search") String search) {
        List<OuvrageEntity> ouvrages = ouvrageService.findBySearch(search);
        return ouvrageMapper.toDTOs(ouvrages);
    }


}
