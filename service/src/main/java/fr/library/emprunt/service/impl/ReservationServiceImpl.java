package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.repository.ReservationRepository;
import fr.library.emprunt.service.ReservationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class ReservationServiceImpl extends CrudServiceImpl<ReservationEntity, Long> implements ReservationService {
    private static final long NOMBRE_JOURS_MIN_RELANCE = 28;
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationRepository getRepository() {

        return reservationRepository;
    }

    @Override
    public ReservationEntity prolonger(Long reservationId) {
        ReservationEntity previousResa = getOne(reservationId);
        previousResa.setDtRetour(LocalDate.now());
        save(previousResa);

        ReservationEntity newRes = new ReservationEntity();
        newRes.setPrevReservationId(previousResa.getId());
        newRes.setUsagerEntity(previousResa.getUsagerEntity());
        newRes.setDtEmprunt(previousResa.getDtEmprunt());
        newRes.setOuvrageEntity(previousResa.getOuvrageEntity());
        return save(newRes);
    }

    @Override
    public List<ReservationEntity> getReservationARelancer() {
        List<ReservationEntity> all = reservationRepository.findAllWhereDtRetourIsNull();
        LocalDate now = LocalDate.now();
        return all.stream().filter(e -> ChronoUnit.DAYS.between(e.getDtEmprunt(), now) > NOMBRE_JOURS_MIN_RELANCE).collect(Collectors.toList());
    }


}
