package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.repository.ReservationRepository;
import fr.library.emprunt.service.ReservationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ReservationServiceImpl extends CrudServiceImpl<ReservationEntity,Long> implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl (ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

    }
    @Override
    public ReservationRepository getRepository(){

        return reservationRepository;
    }
}
