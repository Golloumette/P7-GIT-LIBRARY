package fr.library.emprunt.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDTO extends AbstractDTO {
    private String ouvrage;
    private String usager;
    private LocalDateTime dtEmprunt;
    private LocalDateTime dtRetour;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, String ouvrage, String usager, LocalDateTime dtEmprunt, LocalDateTime dtRetour) {
        super(id);
        this.ouvrage = ouvrage;
        this.usager = usager;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
    }

    public ReservationDTO(String ouvrage, String usager, LocalDateTime dtEmprunt, LocalDateTime dtRetour) {
        this.ouvrage = ouvrage;
        this.usager = usager;
        this.dtEmprunt = dtEmprunt;
        this.dtRetour = dtRetour;
    }
}
