package fr.library.emprunt.mapper;

import fr.library.emprunt.dto.PersonnelDTO;
import fr.library.emprunt.model.PersonnelEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonnelMapper extends AbstractMapper<PersonnelEntity, PersonnelDTO> {

    public PersonnelMapper() {
    }

    @Override
    public PersonnelDTO toDTO(PersonnelEntity entity) {
        return entity == null ? null : new PersonnelDTO(entity.getId(), entity.getNom(), entity.getPrenom(), entity.getFonction(), entity.getIdentifiant());
    }

    @Override
    public PersonnelEntity toEntity(PersonnelDTO dto) {
        if (dto == null) {
            return null;
        }
        return new PersonnelEntity(dto.getId(), dto.getNom(), dto.getPrenom(), dto.getFonction(), dto.getIdentifiant());
    }

    List<String> PersonnelsToNoms(Collection<PersonnelEntity> personnels) {
        if (CollectionUtils.isEmpty(personnels)) {
            return Collections.emptyList();
        }
        return personnels.stream().map(PersonnelEntity::getNom).collect(Collectors.toList());
    }
}
