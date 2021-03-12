package fr.library.emprunt.controller;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RetourReservationRequest {
    private Long id;
    private LocalDate dateRetour;
}
