package fr.library.emprunt.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationDTO extends AbstractDTO {
    private String ouvrage;
    private String usager;
    private LocalDate dtEmprunt;
    private LocalDate dtRetour;
    private Long prevReservationId;


    public ReservationDTO() {
    }

    public ReservationDTO(Long id, String ouvrage, String usager, LocalDate dtEmprunt, LocalDate dtRetour, Long prevReservationId) {
        super(id);
        this.ouvrage = ouvrage;
        this.usager = usager;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
        this.prevReservationId = prevReservationId;
    }

    public ReservationDTO(String ouvrage, String usager, LocalDate dtEmprunt, LocalDate dtRetour, Long prevReservationId) {
        this.ouvrage = ouvrage;
        this.usager = usager;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
        this.prevReservationId = prevReservationId;
    }

    public ReservationDTO(Long id, String ouvrage, String usager, LocalDate dtEmprunt, LocalDate dtRetour) {
        super(id);
        this.ouvrage = ouvrage;
        this.usager = usager;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
    }

    public ReservationDTO(String ouvrage, String usager, LocalDate dtEmprunt, LocalDate dtRetour) {
        this.ouvrage = ouvrage;
        this.usager = usager;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
    }
}
