package fr.library.emprunt.dto;

import fr.library.emprunt.model.GenreOuvrage;
import fr.library.emprunt.model.TypeOuvrage;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OuvrageDTO extends AbstractDTO {
    private String titre;
    private String editeur;
    private LocalDate parution;
    private int exemplaires;
    private GenreOuvrage genre;
    private TypeOuvrage type;
    private List<String> auteurs;


    public OuvrageDTO() {

    }

    public OuvrageDTO(String titre) {
        this.titre = titre;
    }

    public OuvrageDTO(Long id, String titre, String editeur, LocalDate parution, int exemplaires, GenreOuvrage genre, TypeOuvrage type, List<String> auteurs) {
        super(id);
        this.titre = titre;
        this.editeur = editeur;
        this.parution = parution;
        this.exemplaires = exemplaires;
        this.genre = genre;
        this.type = type;
        this.auteurs = auteurs;
    }

    public OuvrageDTO(String titre, String editeur, LocalDate parution, int exemplaires, GenreOuvrage genre, TypeOuvrage type, List<String> auteurs) {
        this.titre = titre;
        this.editeur = editeur;
        this.parution = parution;
        this.exemplaires = exemplaires;
        this.genre = genre;
        this.type = type;
        this.auteurs = auteurs;
    }
}
