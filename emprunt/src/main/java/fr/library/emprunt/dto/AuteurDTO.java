package fr.library.emprunt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AuteurDTO extends AbstractDTO {
    private String nom;
    private String prenom;
    private List<String> ouvrages;

    public AuteurDTO() {
    }

    public AuteurDTO(Long id, String nom, String prenom) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
    }

    public AuteurDTO(Long id, String nom, String prenom,  List<String> ouvrages) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.ouvrages = ouvrages;
    }

    public AuteurDTO(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
