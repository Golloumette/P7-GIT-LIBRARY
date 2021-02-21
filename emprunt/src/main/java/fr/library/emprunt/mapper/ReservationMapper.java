package fr.library.emprunt.mapper;

import fr.library.emprunt.dto.ReservationDTO;
import fr.library.emprunt.dto.ReservationRequest;
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
        String titreOuvrage = entity.getOuvrageEntity() != null ? entity.getOuvrageEntity().getTitre() : null;
        String fullName = entity.getUsagerEntity() != null ? entity.getUsagerEntity().getPrenom() + " " + entity.getUsagerEntity().getNom() : null;
        return new ReservationDTO(
                entity.getId(),
                titreOuvrage,
                fullName,
                entity.getDt_Emprunt(),
                entity.getDt_Retour()) ;


    }

    @Override
    public ReservationEntity toEntity(ReservationDTO dto) {
        if (dto == null) {
            return null;
        }
        throw new RuntimeException("method not implemented");
    }

    public ReservationEntity toEntity(ReservationRequest request) {
        if (request == null) {
            return null;
        }
        OuvrageEntity ouvrageEntity = new OuvrageEntity();
        ouvrageEntity.setId(request.getOuvrageId());
        UsagerEntity usagerEntity = new UsagerEntity();
        usagerEntity.setId(request.getUsagerId());
        return new ReservationEntity(ouvrageEntity, usagerEntity, request.getDateEmprunt(), request.getDateRetour());
    }
    List<OuvrageEntity> reservationToNoms(Collection<ReservationEntity> reservations){
        if(CollectionUtils.isEmpty(reservations)){
            return Collections.emptyList();
        }
        return reservations.stream().map(ReservationEntity::getOuvrageEntity).collect(Collectors.toList());
    }
}
