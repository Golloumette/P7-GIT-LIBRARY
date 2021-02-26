package fr.library.emprunt.mapper;


import fr.library.emprunt.dto.OuvrageDTO;
import fr.library.emprunt.model.AuteurEntity;
import fr.library.emprunt.model.OuvrageEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OuvrageMapper extends AbstractMapper<OuvrageEntity, OuvrageDTO> {

    @Override
    public OuvrageDTO toDTO(OuvrageEntity ouvrage) {
        return ouvrage == null ?
                null : new OuvrageDTO(
                        ouvrage.getId(),
                ouvrage.getTitre(),
                ouvrage.getEditeur(),
                ouvrage.getParution(),
                ouvrage.getGenre(),
                ouvrage.getType(),
                nomAuteurs(ouvrage));
    }

    /**
     * Récupère la liste des noms d'autreus d'un ouvrage
     * @param ouvrage l'ouvrage dont ont souhaite avoir la liste des noms d'auteurs
     * @return La liste des noms d'auteurs de l'ouvrage passé en param
     */
    List<String> nomAuteurs(OuvrageEntity ouvrage) {
        if (ouvrage == null || CollectionUtils.isEmpty(ouvrage.getAuteurs())) {
            return Collections.emptyList();
        }
        return ouvrage.getAuteurs().stream().map(AuteurEntity::getNom).collect(Collectors.toList());
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
