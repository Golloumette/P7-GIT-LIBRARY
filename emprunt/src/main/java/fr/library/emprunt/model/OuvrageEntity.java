package fr.library.emprunt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ouvrage")
public class OuvrageEntity extends AbstractEntity {
    private String titre;
    private String editeur;
    private LocalDateTime parution;
    private int exemplaires = 0;
    @OneToMany(targetEntity = ReservationEntity.class, mappedBy = "ouvrageEntity", fetch = FetchType.EAGER)
    private List<ReservationEntity> reservationEntitys;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('SCIENCE_FICTION', 'SCIENCE_FICTION')")
    private GenreOuvrage genre;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('REVUE', 'BD')")
    private TypeOuvrage type;
    @ManyToMany(mappedBy = "ouvrages")
    private Set<AuteurEntity> auteurs = new HashSet<>();

    public OuvrageEntity() {
    }

    public OuvrageEntity(String titre) {
        this.titre = titre;
    }

    public OuvrageEntity(String titre, String editeur, LocalDateTime parution, List<ReservationEntity> reservationEntitys, GenreOuvrage genre, TypeOuvrage type, Set<AuteurEntity> auteurs) {
        this.titre = titre;
        this.editeur = editeur;
        this.parution = parution;
        this.reservationEntitys = reservationEntitys;
        this.genre = genre;
        this.type = type;
        this.auteurs = auteurs;
    }

    public OuvrageEntity(Long id, String titre, String editeur, LocalDateTime parution, List<ReservationEntity> reservationEntitys, GenreOuvrage genre, TypeOuvrage type, Set<AuteurEntity> auteurs) {
        super(id);
        this.titre = titre;
        this.editeur = editeur;
        this.parution = parution;
        this.reservationEntitys = reservationEntitys;
        this.genre = genre;
        this.type = type;
        this.auteurs = auteurs;
    }

    @Override
    public String toString() {
        return "OuvrageEntity{" +
                "titre='" + titre + '\'' +
                '}';
    }
}

