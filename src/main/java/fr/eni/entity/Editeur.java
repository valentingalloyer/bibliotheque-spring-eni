package fr.eni.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Editeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "L''éditeur doit avoir un nom")
    @Column(unique = true)
    private String libelle;

    public Editeur() {
    }

    public Editeur(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Editeur{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
