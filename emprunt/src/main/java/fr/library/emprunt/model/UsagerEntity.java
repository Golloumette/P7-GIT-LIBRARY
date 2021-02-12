package fr.library.emprunt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="usager")
public class UsagerEntity  extends AbstractEntity{
    private String nom;
    private String prenom;
    private String pseudo;
    private String password;
    private String adresse;
    private String ville;
    private String mail;
    private String telephone;
    @OneToMany(targetEntity = ReservationEntity.class,mappedBy = "usagerEntity", fetch = FetchType.EAGER)
    private List<ReservationEntity> reservationEntitys;

    public UsagerEntity() {

    }



    @Override
    public String toString() {
        return "UsagerEntity{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
