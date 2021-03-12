package fr.library.emprunt.repository;

import fr.library.emprunt.model.PersonnelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelEntity, Long> {
}
