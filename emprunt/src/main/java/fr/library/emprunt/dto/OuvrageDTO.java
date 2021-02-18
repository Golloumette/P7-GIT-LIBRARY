package fr.library.emprunt.dto;

import fr.library.emprunt.model.GenreOuvrage;
import fr.library.emprunt.model.TypeOuvrage;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OuvrageDTO extends AbstractDTO {
    private String titre;
    private String editeur;
    private LocalDateTime parution;
    private GenreOuvrage genre;
    private TypeOuvrage type;
    private Set<AuteurDTO> auteurs = new HashSet<>();

    public OuvrageDTO() {
    }

    public OuvrageDTO(Long id, String titre, String editeur, LocalDateTime parution, GenreOuvrage genre, TypeOuvrage type, Set<AuteurDTO> auteurs) {
        super(id);
        this.titre = titre;
        this.editeur = editeur;
        this.parution = parution;
        this.genre = genre;
        this.type = type;
        this.auteurs = auteurs;
    }

    public OuvrageDTO(String titre, String editeur, LocalDateTime parution, GenreOuvrage genre, TypeOuvrage type, Set<AuteurDTO> auteurs) {
        this.titre = titre;
        this.editeur = editeur;
        this.parution = parution;
        this.genre = genre;
        this.type = type;
        this.auteurs = auteurs;
    }
}
