package fr.library.emprunt;

import fr.library.emprunt.model.OuvrageEntity;
import fr.library.emprunt.service.OuvrageService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class OuvrageServiceUnitTest {

    @Autowired
    private OuvrageService ouvrageService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialesRecords(){
        List<OuvrageEntity> ouvrageEntities = ouvrageService.findAll();

        Assert.assertEquals(ouvrageEntities.size(),1);
    }

}
