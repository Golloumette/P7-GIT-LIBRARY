package fr.library.emprunt.service;

import fr.library.emprunt.model.ReservationEntity;

public interface ReservationService extends CrudService<ReservationEntity, Long> {
    ReservationEntity prolonger(Long reservationId);
}
