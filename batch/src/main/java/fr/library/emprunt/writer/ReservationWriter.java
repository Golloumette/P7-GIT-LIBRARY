package fr.library.emprunt.writer;

import fr.library.emprunt.model.ReservationEntity;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ReservationWriter implements ItemWriter<ReservationEntity> {
    @Override
    public void write(List<? extends ReservationEntity> items) throws Exception {
        System.out.println("items = " + items);
    }
}
