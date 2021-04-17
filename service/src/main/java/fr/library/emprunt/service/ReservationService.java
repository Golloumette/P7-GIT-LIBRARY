package fr.library.emprunt.service;

import fr.library.emprunt.model.ReservationEntity;

import java.util.List;

public interface ReservationService extends CrudService<ReservationEntity, Long> {
    ReservationEntity prolonger(Long reservationId);

    List<ReservationEntity> getReservationARelancer();
}
