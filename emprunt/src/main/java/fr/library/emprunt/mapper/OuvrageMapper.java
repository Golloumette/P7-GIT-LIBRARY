package fr.library.emprunt.mapper;


import fr.library.emprunt.dto.OuvrageDTO;
import fr.library.emprunt.model.OuvrageEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OuvrageMapper extends AbstractMapper<OuvrageEntity, OuvrageDTO> {
    @Override
    public OuvrageDTO toDTO(OuvrageEntity entity) {
        return null;
    }

    @Override
    public OuvrageEntity toEntity(OuvrageDTO dto) {
        return null;
    }

    List<String> ouvragesToNoms(Collection<OuvrageEntity> ouvrages) {
        if (CollectionUtils.isEmpty(ouvrages)) {
            return Collections.emptyList();
        }
        return ouvrages.stream().map(OuvrageEntity::getTitre).collect(Collectors.toList());
    }

    Set<OuvrageEntity> nomsToOuvrages(Collection<String> titles) {
        if (CollectionUtils.isEmpty(titles)) {
            return Collections.emptySet();
        }
        return titles.stream().map(OuvrageEntity::new).collect(Collectors.toSet());
    }
}
