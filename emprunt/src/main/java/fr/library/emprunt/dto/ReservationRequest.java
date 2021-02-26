package fr.library.emprunt.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private long ouvrageId;
    private long usagerId;
    private LocalDate dtEmprunt;
    private LocalDate dtRetour;
}
