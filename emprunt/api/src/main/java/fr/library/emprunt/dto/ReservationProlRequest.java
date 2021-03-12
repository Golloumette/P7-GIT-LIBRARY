package fr.library.emprunt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationProlRequest {
    private long ouvrageId;
    private long usagerId;
    private LocalDate dtEmprunt;
    private LocalDate dtRetour;
    private Long prevReservationId ;
}
