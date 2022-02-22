package fr.eni.bll;

import fr.eni.entity.Editeur;

import java.util.List;

public interface EditeurService {

    Editeur trouverEditeur(Long id) throws BllException;

    List<Editeur> listerEditeurs();

    void ajouterEditeur(Editeur editeur) throws BllException;

    void modifierEditeur(Editeur editeur) throws BllException;

    void supprimerEditeur(Long id) throws BllException;
}
