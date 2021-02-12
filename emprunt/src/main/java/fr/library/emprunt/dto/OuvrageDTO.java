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
}
