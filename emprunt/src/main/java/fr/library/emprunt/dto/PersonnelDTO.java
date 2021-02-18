package fr.library.emprunt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonnelDTO extends AbstractDTO {
    private String nom;
    private String prenom;
    private String fonction;
    private String identifiant;

    public PersonnelDTO() {
    }

    public PersonnelDTO(Long id, String nom, String prenom, String fonction, String identifiant) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.identifiant = identifiant;
    }

    public PersonnelDTO(String nom, String prenom, String fonction, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.identifiant = identifiant;
    }
}
