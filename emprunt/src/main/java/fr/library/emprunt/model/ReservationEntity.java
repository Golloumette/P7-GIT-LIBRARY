package fr.library.emprunt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class ReservationEntity extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ouvrage_id")
    private OuvrageEntity ouvrageEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usager_id")
    private UsagerEntity usagerEntity;
    private LocalDateTime dt_Emprunt;
    private LocalDateTime dt_Retour;

    public ReservationEntity() {

    }

    public ReservationEntity(OuvrageEntity ouvrageEntity, UsagerEntity usagerEntity, LocalDateTime dt_Emprunt, LocalDateTime dt_Retour) {
        this.ouvrageEntity = ouvrageEntity;
        this.usagerEntity = usagerEntity;
        this.dt_Emprunt = dt_Emprunt;
        if (dt_Retour != null) {
            this.dt_Retour = dt_Retour;
        } else {
            this.dt_Retour = LocalDateTime.of(2021,02,21,16,17);
        }
    }

    public ReservationEntity(Long id, OuvrageEntity ouvrageEntity, UsagerEntity usagerEntity, LocalDateTime dt_Emprunt, LocalDateTime dt_Retour) {
        super(id);
        this.ouvrageEntity = ouvrageEntity;
        this.usagerEntity = usagerEntity;
        this.dt_Emprunt = dt_Emprunt;
        this.dt_Retour = dt_Retour;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "ouvrageEntity=" + ouvrageEntity +
                ", usagerEntity=" + usagerEntity +
                ", dt_Emprunt=" + dt_Emprunt +
                ", dt_Retour=" + dt_Retour +
                '}';
    }
}
