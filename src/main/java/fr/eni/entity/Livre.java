package fr.eni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String titre;

    @Column(length = 50)
    private String auteur;

    private boolean lu;

    @Column(length = 20)
    private String isbn;

    @Lob
    private String resume;

    private Integer nombreDePages;

    @ManyToOne
    private Editeur editeur;

    public Livre() {
    }

    public Livre(String titre, String auteur, boolean lu, String isbn, String resume, Integer nombreDePages, Editeur editeur) {
        this.titre = titre;
        this.auteur = auteur;
        this.lu = lu;
        this.isbn = isbn;
        this.resume = resume;
        this.nombreDePages = nombreDePages;
        this.editeur = editeur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", lu=" + lu +
                ", isbn='" + isbn + '\'' +
                ", resume='" + resume + '\'' +
                ", nombreDePages=" + nombreDePages +
                ", editeur=" + editeur +
                '}';
    }
}