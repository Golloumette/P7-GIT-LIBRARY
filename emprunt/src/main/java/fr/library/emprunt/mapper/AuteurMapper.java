package fr.library.emprunt.mapper;

import fr.library.emprunt.dto.AuteurDTO;
import fr.library.emprunt.model.AuteurEntity;
import org.springframework.stereotype.Component;

@Component
public class AuteurMapper extends AbstractMapper<AuteurEntity, AuteurDTO> {

    private final OuvrageMapper ouvrageMapper;

    public AuteurMapper(OuvrageMapper ouvrageMapper) {
        this.ouvrageMapper = ouvrageMapper;
    }

    @Override
    public AuteurDTO toDTO(AuteurEntity entity) {
        return entity == null ? null : new AuteurDTO(entity.getId(), entity.getNom(), entity.getPrenom(), ouvrageMapper.ouvragesToNoms(entity.getOuvrages()));

    }

    @Override
    public AuteurEntity toEntity(AuteurDTO dto) {
        if (dto == null ) {
            return null;
        }
        return new AuteurEntity(dto.getId(), dto.getNom(), dto.getPrenom(), ouvrageMapper.nomsToOuvrages(dto.getOuvrages()));
    }
}

