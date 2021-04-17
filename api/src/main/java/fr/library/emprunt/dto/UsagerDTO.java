package fr.library.emprunt.dto;


import fr.library.emprunt.model.ReservationEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsagerDTO extends AbstractDTO {
    private String nom;
    private String prenom;
    private String pseudo;
    private String adresse;
    private String ville;
    private String mail;
    private String telephone;
    private List<ReservationEntity> reservationEntitys;

    public UsagerDTO(Long id, String nom, String prenom, String pseudo, String adresse, String ville, String mail, String telephone) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.adresse = adresse;
        this.ville = ville;
        this.mail = mail;
        this.telephone = telephone;
    }

    public UsagerDTO(String nom, String prenom, String pseudo, String adresse, String ville, String mail, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.adresse = adresse;
        this.ville = ville;
        this.mail = mail;
        this.telephone = telephone;
    }

    public UsagerDTO() {

    }

    public UsagerDTO(Long id, String nom, String prenom, String pseudo, String adresse, String ville, String mail, String telephone, List<ReservationEntity> reservationEntitys) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.adresse = adresse;
        this.ville = ville;
        this.mail = mail;
        this.telephone = telephone;
        this.reservationEntitys = reservationEntitys;
    }

    public UsagerDTO(String nom, String prenom, String pseudo, String adresse, String ville, String mail, String telephone, List<ReservationEntity> reservationEntitys) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.adresse = adresse;
        this.ville = ville;
        this.mail = mail;
        this.telephone = telephone;
        this.reservationEntitys = reservationEntitys;
    }
}
