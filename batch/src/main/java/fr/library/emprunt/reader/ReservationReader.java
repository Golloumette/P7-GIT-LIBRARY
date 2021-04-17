package fr.library.emprunt.reader;

import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.service.ReservationService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class ReservationReader implements ItemReader<ReservationEntity> {

    @Autowired
    private ReservationService service;

    private Iterator<ReservationEntity> reservationIterator;



    @Override
    public ReservationEntity read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (reservationIterator == null) {
            reservationIterator = service.getReservationARelancer().iterator();
        }
        if (reservationIterator.hasNext()) {
            return reservationIterator.next();
        }

        return null;
    }
}
