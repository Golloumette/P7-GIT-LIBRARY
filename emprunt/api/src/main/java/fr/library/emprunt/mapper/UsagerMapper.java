package fr.library.emprunt.mapper;

import fr.library.emprunt.dto.UsagerDTO;
import fr.library.emprunt.model.UsagerEntity;
import org.springframework.stereotype.Component;

@Component
public class UsagerMapper extends AbstractMapper<UsagerEntity, UsagerDTO> {

    private final ReservationMapper reservationMapper;

    public UsagerMapper(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public UsagerDTO toDTO (UsagerEntity entity){
        //ajout get entitity reservation
        return entity == null ? null : new UsagerDTO(entity.getId(),
                entity.getNom(),
                entity.getPrenom(),
                entity.getPseudo(),
                entity.getAdresse(),
                entity.getVille(),
                entity.getMail(),
                entity.getVille());
    }

    @Override
    public UsagerEntity toEntity(UsagerDTO dto) {
        if (dto == null) {
            return null;
        }
        return new UsagerEntity(dto.getId(), dto.getNom(), dto.getPrenom(), dto.getPseudo(), dto.getAdresse(), dto.getVille(), dto.getMail(), dto.getTelephone());
    }
}
