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
@Table(name="personnel")
public class PersonnelEntity extends AbstractEntity{
    private String nom;
    private String prenom;
    private String fonction;
    private String identifiant;
    private String password;

    @Override
    public String toString() {
        return "PersonnelEntity{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
