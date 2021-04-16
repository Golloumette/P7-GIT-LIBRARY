package fr.library.emprunt.repository;

import fr.library.emprunt.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    @Query("select r from ReservationEntity r left join fetch r.ouvrageEntity left join fetch r.usagerEntity where r.dtRetour is null")
    List<ReservationEntity> findAllWhereDtRetourIsNull();
}
