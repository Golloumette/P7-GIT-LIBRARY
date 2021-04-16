package fr.library.emprunt.repository;

import fr.library.emprunt.model.AuteurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuteurRepository extends JpaRepository<AuteurEntity,Long> {
    @Override
    @Query("select a from AuteurEntity a left join fetch a.ouvrages o left join fetch o.reservationEntitys r")
    List<AuteurEntity> findAll();
}
