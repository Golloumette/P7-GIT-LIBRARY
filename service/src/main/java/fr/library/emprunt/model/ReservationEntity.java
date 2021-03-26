package fr.library.emprunt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate dtEmprunt;
    private LocalDate dtRetour;
    private Long prevReservationId;

    public ReservationEntity() {

    }

    public ReservationEntity(LocalDate dtRetour) {
        this.dtRetour = dtRetour;
    }

    public ReservationEntity(OuvrageEntity ouvrageEntity, UsagerEntity usagerEntity, LocalDate dtEmprunt, LocalDate dtRetour) {
        this.ouvrageEntity = ouvrageEntity;
        this.usagerEntity = usagerEntity;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
    }

    public ReservationEntity(Long id, OuvrageEntity ouvrageEntity, UsagerEntity usagerEntity, LocalDate dtEmprunt, LocalDate dtRetour) {
        super(id);
        this.ouvrageEntity = ouvrageEntity;
        this.usagerEntity = usagerEntity;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
    }

    public ReservationEntity(OuvrageEntity ouvrageEntity, UsagerEntity usagerEntity, LocalDate dtEmprunt, LocalDate dtRetour, Long prevReservationId) {
        this.ouvrageEntity = ouvrageEntity;
        this.usagerEntity = usagerEntity;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
        this.prevReservationId = prevReservationId;
    }

    public ReservationEntity(Long id, OuvrageEntity ouvrageEntity, UsagerEntity usagerEntity, LocalDate dtEmprunt, LocalDate dtRetour, Long prevReservationId) {
        super(id);
        this.ouvrageEntity = ouvrageEntity;
        this.usagerEntity = usagerEntity;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
        this.prevReservationId = prevReservationId;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "ouvrageEntity=" + ouvrageEntity +
                ", usagerEntity=" + usagerEntity +
                ", dt_Emprunt=" + dtEmprunt +
                ", dt_Retour=" + dtRetour +
                '}';
    }
}
