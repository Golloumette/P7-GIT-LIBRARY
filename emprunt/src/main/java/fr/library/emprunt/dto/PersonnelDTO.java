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
}
