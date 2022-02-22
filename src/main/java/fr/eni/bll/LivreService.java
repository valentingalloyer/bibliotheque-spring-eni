package fr.eni.bll;

import fr.eni.entity.Livre;

import java.util.List;

public interface LivreService {

	Livre trouverLivre(long id) throws BllException;
	List<Livre> listerLivres();
	void ajouterLivre(Livre livre) throws BllException;
	void modifierLivre(long id, Livre livreApresModif) throws BllException;
	void supprimerLivre(long id) throws BllException;
//	void ajouterAvis(int idLivre, Avis av);
}
