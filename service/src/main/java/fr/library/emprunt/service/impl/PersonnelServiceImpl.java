package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.PersonnelEntity;
import fr.library.emprunt.repository.PersonnelRepository;
import fr.library.emprunt.service.PersonnelService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonnelServiceImpl extends CrudServiceImpl<PersonnelEntity, Long> implements PersonnelService {
    private final PersonnelRepository personnelRepository;

    public PersonnelServiceImpl(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @Override
    public PersonnelRepository getRepository() {

        return personnelRepository;
    }
}
