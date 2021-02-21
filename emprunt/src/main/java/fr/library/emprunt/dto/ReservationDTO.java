package fr.library.emprunt.dto;

import lombok.Getter;
import lombok.Setter;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ReservationDTO extends AbstractDTO {
    private String ouvrage;
    private String usager;
    private LocalDateTime dt_Emprunt;
    private LocalDateTime dt_Retour;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, String ouvrage, String usager, LocalDateTime dt_Emprunt, LocalDateTime dt_Retour) {
        super(id);
        this.ouvrage = ouvrage;
        this.usager = usager;
        this.dt_Emprunt = dt_Emprunt;
        if (dt_Retour != null) {
            this.dt_Retour = dt_Retour;
        } else {
            this.dt_Retour = LocalDateTime.of(2021,02,21,16,17);
        }
    }
    public ReservationDTO(String ouvrage, String usager, LocalDateTime dt_Emprunt, LocalDateTime dt_Retour) {
        this.ouvrage = ouvrage;
        this.usager = usager;
        this.dt_Emprunt = dt_Emprunt;
        if (dt_Retour != null) {
            this.dt_Retour = dt_Retour;
        } else {
            this.dt_Retour = LocalDateTime.of(2021,02,21,16,17);
        }
    }
}
