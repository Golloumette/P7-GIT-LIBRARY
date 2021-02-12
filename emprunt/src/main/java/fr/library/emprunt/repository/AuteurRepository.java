package fr.library.emprunt.repository;

import fr.library.emprunt.model.AuteurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<AuteurEntity,Long> {
}
