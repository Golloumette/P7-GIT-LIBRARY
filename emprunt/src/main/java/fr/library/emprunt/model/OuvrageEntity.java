package fr.library.emprunt.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Ouvrage")
public class OuvrageEntity extends AbstractEntity {
    private String titre;
    private String editeur;
    private LocalDateTime parution;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('SCIENCE_FICTION', 'SCIENCE_FICTION')")
    private GenreOuvrage genre;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('REVUE', 'BD')")
    private TypeOuvrage type;

    public OuvrageEntity() {
    }

    @Override
    public String toString() {
        return "OuvrageEntity{" +
                "titre='" + titre + '\'' +
                '}';
    }
}

