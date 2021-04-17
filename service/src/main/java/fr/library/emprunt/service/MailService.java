package fr.library.emprunt.service;

import fr.library.emprunt.model.ReservationEntity;

public interface MailService {
    void sendSimpleMessage();

    void relanceMail(ReservationEntity reservationEntity);
}
