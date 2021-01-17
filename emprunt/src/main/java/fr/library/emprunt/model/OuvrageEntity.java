package fr.library.emprunt.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Ouvrage")
public class OuvrageEntity extends AbstractEntity {
    private String nom;

    @Override
    public String toString() {
        return "OuvrageEntity{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
