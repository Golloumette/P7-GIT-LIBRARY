package fr.library.emprunt.batch.reader;

import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.repository.ReservationRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * todo: utiliser ce bean pour le reader sinon la config est déjà suffisante. Donc le supprimer
 */
public class ReservationItemReader extends RepositoryItemReader<ReservationEntity> {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void setRepository(PagingAndSortingRepository<?, ?> repository) {
        super.setRepository(reservationRepository);
    }

    @Override
    public void setMethodName(String methodName) {
        super.setMethodName("findAll");
    }

    @Override
    public void setPageSize(int pageSize) {
        super.setPageSize(40);
    }

    @Override
    public void setSort(Map<String, Sort.Direction> sorts) {
        HashMap<String, Sort.Direction> sort = new HashMap<>();
        sort.put("id", Sort.Direction.DESC);
        super.setSort(sort);
    }
}
