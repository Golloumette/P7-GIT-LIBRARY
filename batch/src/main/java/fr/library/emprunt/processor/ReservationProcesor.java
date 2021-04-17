package fr.library.emprunt.processor;

import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.service.MailService;
import fr.library.emprunt.service.impl.MailServiceImpl;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationProcesor implements ItemProcessor<ReservationEntity, ReservationEntity> {

    @Autowired
    private MailService mailService;


    @Override
    public ReservationEntity process(ReservationEntity item) throws Exception {
       mailService.relanceMail(item);
        return item;
    }

}
