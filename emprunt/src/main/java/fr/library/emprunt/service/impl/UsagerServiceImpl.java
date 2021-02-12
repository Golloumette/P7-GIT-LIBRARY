package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.UsagerEntity;
import fr.library.emprunt.repository.UsagerRepository;
import fr.library.emprunt.service.UsagerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UsagerServiceImpl extends CrudServiceImpl<UsagerEntity,Long>implements UsagerService {
    private final UsagerRepository usagerRepository;

    public UsagerServiceImpl(UsagerRepository usagerRepository) {
        this.usagerRepository = usagerRepository;
    }

    @Override
    public UsagerRepository getRepository() {
        return usagerRepository;
    }

}
