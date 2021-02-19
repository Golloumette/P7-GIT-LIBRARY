package fr.library.emprunt.mapper;

import fr.library.emprunt.dto.ReservationDTO;
import fr.library.emprunt.model.OuvrageEntity;
import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.model.UsagerEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper extends AbstractMapper<ReservationEntity, ReservationDTO> {

    @Override
    public ReservationDTO toDTO(ReservationEntity entity) {
        if (entity == null) {
            return null;
        }

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(entity.getId());
        UsagerEntity usagerEntity = entity.getUsagerEntity();
        if (usagerEntity != null) {
            reservationDTO.setUsager(usagerEntity.getNom() + " "+ usagerEntity.getPrenom());
        }

        OuvrageEntity ouvrageEntity = entity.getOuvrageEntity();
        if (ouvrageEntity != null) {
            reservationDTO.setOuvrage(ouvrageEntity.getTitre());
        }
        reservationDTO.setDtEmprunt(entity.getDtEmprunt());
        reservationDTO.setDtRetour(entity.getDtRetour());
        return reservationDTO;
    }

    @Override
    public ReservationEntity toEntity(ReservationDTO dto) {

        return null;
    }
    List<String> reservationID(Collection<UsagerEntity> reservations) {
        if (CollectionUtils.isEmpty(reservations)){
            return Collections.emptyList();
        }
        return Collections.emptyList();
       // return reservations.stream().map((UsagerEntity t) -> ReservationEntity).collect(Collectors.toList());
    }
}
