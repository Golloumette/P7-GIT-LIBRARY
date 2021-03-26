package fr.library.emprunt.processor;

import fr.library.emprunt.model.ReservationEntity;
import org.springframework.batch.item.ItemProcessor;

public class ReservationProcesor implements ItemProcessor<ReservationEntity, ReservationEntity> {
    @Override
    public ReservationEntity process(ReservationEntity item) throws Exception {
        System.out.println("item = " + item);
        return item;
    }
}
