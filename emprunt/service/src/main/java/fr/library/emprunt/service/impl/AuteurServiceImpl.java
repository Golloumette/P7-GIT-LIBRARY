package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.AuteurEntity;
import fr.library.emprunt.repository.AuteurRepository;
import fr.library.emprunt.service.AuteurService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuteurServiceImpl extends CrudServiceImpl<AuteurEntity,Long> implements AuteurService {
    private final AuteurRepository auteurRepository;

    public AuteurServiceImpl (AuteurRepository auteurRepository){
        this.auteurRepository = auteurRepository;
    }

    @Override
    public AuteurRepository getRepository(){

        return auteurRepository;
    }
}
