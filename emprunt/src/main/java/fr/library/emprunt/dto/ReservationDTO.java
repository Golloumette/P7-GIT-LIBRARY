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
}
