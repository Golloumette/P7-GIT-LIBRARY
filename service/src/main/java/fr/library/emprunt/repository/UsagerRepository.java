package fr.library.emprunt.repository;

import fr.library.emprunt.model.UsagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsagerRepository extends JpaRepository<UsagerEntity,Long> {
}
