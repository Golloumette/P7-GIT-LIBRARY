package fr.library.emprunt.dto;


import fr.library.emprunt.model.ReservationEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class UsagerDTO extends AbstractDTO {
    private String nom;
    private String prenom;
    private String pseudo;
    private String password;
    private String adresse;
    private String ville;
    private String mail;
    private String telephone;
    private List<ReservationEntity> reservationEntitys;

    public UsagerDTO() {

    }
}
