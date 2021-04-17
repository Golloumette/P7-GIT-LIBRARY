package fr.library.emprunt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Personnel")
public class PersonnelEntity extends AbstractEntity {
    private String nom;
    private String prenom;
    private String fonction;
    private String identifiant;
    private String password;

    public PersonnelEntity() {

    }

    public PersonnelEntity(String nom, String prenom, String fonction, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.identifiant = identifiant;

    }

    public PersonnelEntity(Long id, String nom, String prenom, String fonction, String identifiant) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.identifiant = identifiant;

    }

    @Override
    public String toString() {
        return "PersonnelEntity{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
