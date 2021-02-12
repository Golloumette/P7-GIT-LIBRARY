package fr.library.emprunt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "auteur")
public class AuteurEntity extends AbstractEntity {
    private String nom;
    private String prenom;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "auteur_ouvrage",
            joinColumns = {@JoinColumn(name = "auteur_id")},
            inverseJoinColumns = {@JoinColumn(name = "ouvrage_id")}
    )
    Set<OuvrageEntity> ouvrages = new HashSet<>();

    public AuteurEntity() {

    }

    public AuteurEntity(String nom, String prenom, Set<OuvrageEntity> ouvrages) {
        this.nom = nom;
        this.prenom = prenom;
        this.ouvrages = ouvrages;
    }

    public AuteurEntity(Long id, String nom, String prenom, Set<OuvrageEntity> ouvrages) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.ouvrages = ouvrages;
    }

    @Override
    public String toString() {
        return "AuteurEntity{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
