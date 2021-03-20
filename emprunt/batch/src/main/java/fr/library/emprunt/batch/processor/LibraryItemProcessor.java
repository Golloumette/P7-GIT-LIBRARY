package fr.library.emprunt.batch.processor;

import fr.library.emprunt.model.ReservationEntity;
import org.springframework.batch.item.ItemProcessor;


public class LibraryItemProcessor implements ItemProcessor<ReservationEntity, ReservationEntity> {
    @Override
    public ReservationEntity process(ReservationEntity reservationEntity) throws Exception {
        return null;
    }
}
