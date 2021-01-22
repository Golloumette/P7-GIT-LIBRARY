package fr.library.emprunt.repository;

import fr.library.emprunt.model.OuvrageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OuvrageRepository extends JpaRepository <OuvrageEntity, Long> {
}
