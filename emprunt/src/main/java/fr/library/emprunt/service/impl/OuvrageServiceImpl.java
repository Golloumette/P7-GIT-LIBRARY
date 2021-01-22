package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.OuvrageEntity;
import fr.library.emprunt.repository.OuvrageRepository;
import fr.library.emprunt.service.OuvrageService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OuvrageServiceImpl extends CrudServiceImpl<OuvrageEntity, Long> implements OuvrageService {
    private final OuvrageRepository ouvrageRepository;

    public OuvrageServiceImpl(OuvrageRepository ouvrageRepository) {
        this.ouvrageRepository = ouvrageRepository;
    }

    @Override
    public OuvrageRepository getRepository() {
        return ouvrageRepository;
    }
}
