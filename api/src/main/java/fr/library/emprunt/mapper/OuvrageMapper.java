package fr.library.emprunt.mapper;


import fr.library.emprunt.dto.OuvrageDTO;
import fr.library.emprunt.model.AuteurEntity;
import fr.library.emprunt.model.OuvrageEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OuvrageMapper extends AbstractMapper<OuvrageEntity, OuvrageDTO> {


    @Override
    public OuvrageDTO toDTO(OuvrageEntity ouvrage) {
        if (ouvrage == null) {
            return null;
        }

        OuvrageDTO ouvrageDTO = new OuvrageDTO();
        ouvrageDTO.setId(ouvrage.getId());
        ouvrageDTO.setTitre(ouvrage.getTitre());
        ouvrageDTO.setEditeur(ouvrage.getEditeur());
        ouvrageDTO.setParution(ouvrage.getParution());
        ouvrageDTO.setExemplaires(ouvrage.getExemplaires());
        ouvrageDTO.setGenre(ouvrage.getGenre());
        ouvrageDTO.setType(ouvrage.getType());
        ouvrageDTO.setAuteurs(nomAuteurs(ouvrage));
        return ouvrageDTO;
    }

        /*
        public OuvrageDTO titre(OuvrageEntity ouvrage){
        return ouvrage == null ?
                null : new OuvrageDTO(ouvrage.getTitre());
    }*/

    /**
     * Récupère la liste des noms d'auteurs d'un ouvrage
     *
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

    public List<String> ouvragesToNoms(Collection<OuvrageEntity> ouvrages) {
        if (CollectionUtils.isEmpty(ouvrages)) {
            return Collections.emptyList();
        }
        return ouvrages.stream().map(OuvrageEntity::getTitre).collect(Collectors.toList());
    }

    public Set<OuvrageEntity> nomsToOuvrages(Collection<String> titles) {
        if (CollectionUtils.isEmpty(titles)) {
            return Collections.emptySet();
        }
        return titles.stream().map(OuvrageEntity::new).collect(Collectors.toSet());
    }
}
