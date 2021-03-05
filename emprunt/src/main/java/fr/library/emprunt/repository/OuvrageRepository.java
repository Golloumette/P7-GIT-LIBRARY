package fr.library.emprunt.repository;

import fr.library.emprunt.model.OuvrageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface OuvrageRepository extends JpaRepository<OuvrageEntity, Long>, JpaSpecificationExecutor<OuvrageEntity> {
    @Query("select distinct o from OuvrageEntity o left join fetch o.auteurs a left join fetch o.reservationEntitys r")
   // @Query("select o from OuvrageEntity o left join fetch o.auteurs a left join fetch o.reservationEntitys r")
    List<OuvrageEntity> findAll();



    /*@Query("select * from OuvrageEntity where titre like'%'harry'%'")
        Collections <OuvrageEntity> findAll(String title);*/


    //*@Query("select * from OuvrageEntity where titre like '%harry%'")

}


