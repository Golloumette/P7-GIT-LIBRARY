package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.OuvrageEntity;
import fr.library.emprunt.repository.OuvrageRepository;
import fr.library.emprunt.service.OuvrageService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OuvrageServiceImpl implements OuvrageService {
    private final OuvrageRepository ouvrageRepository;

    public OuvrageServiceImpl(OuvrageRepository ouvrageRepository) {
        this.ouvrageRepository = ouvrageRepository;
    }

    public List<OuvrageEntity> list(){
        return ouvrageRepository.findAll();
    }

}
