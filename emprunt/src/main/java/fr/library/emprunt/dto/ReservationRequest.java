package fr.library.emprunt.dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private long ouvrageId;
    private long usagerId;
    private LocalDateTime dateEmprunt;
    private LocalDateTime dateRetour;
}
