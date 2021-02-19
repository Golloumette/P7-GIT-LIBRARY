package fr.library.emprunt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime dtEmprunt;
    private LocalDateTime dtRetour;

    public ReservationEntity() {

    }


    public ReservationEntity(OuvrageEntity ouvrageEntity, UsagerEntity usagerEntity, LocalDateTime dtEmprunt, LocalDateTime dtRetour) {
        this.ouvrageEntity = ouvrageEntity;
        this.usagerEntity = usagerEntity;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
    }

    public ReservationEntity(Long id, OuvrageEntity ouvrageEntity, UsagerEntity usagerEntity, LocalDateTime dtEmprunt, LocalDateTime dtRetour) {
        super(id);
        this.ouvrageEntity = ouvrageEntity;
        this.usagerEntity = usagerEntity;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +

                ", dt_emprunt=" + dtEmprunt +
                ", dt_retour=" + dtRetour +
                '}';
    }
}
