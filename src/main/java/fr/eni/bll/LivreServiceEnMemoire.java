package fr.eni.bll;

import fr.eni.bo.*;
import fr.eni.dal.LivreDAO;
import fr.eni.entity.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreServiceEnMemoire implements LivreService{
	
	@Autowired
	private ConnexionService connexionService;

	@Autowired
	private LivreDAO livreDAO;

	@Override
	public Livre trouverLivre(long id) throws BllException {
		Optional<Livre> opt = livreDAO.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new BllException("Pas de livre trouvé");
		}
	}

	@Override
	public List<Livre> listerLivres() {
		return livreDAO.findAll();
	}

	@Override
	public void ajouterLivre(Livre livre) throws BllException {
		if (livre == null) {
			throw new BllException("Le livre est null");
		} else {
			if (livre.getTitre() == null || livre.getTitre().trim().isEmpty()) {
				throw new BllException("Le titre est obligatoire");
			}
			if (livre.getNombreDePages() < 1) {
				throw new BllException("Le nombre de pages doit être strictement positif");
			}
			if (livre.getEditeur() == null) {
				throw new BllException("L'éditeur est obligatoire");
			}
			livre.setLu(false);
		}

		livreDAO.save(livre);
	}

	@Override
	public void modifierLivre(long id, Livre livreApresModif) throws BllException {
		livreDAO.save(livreApresModif);
	}

	@Override
	public void supprimerLivre(long id) throws BllException {
		livreDAO.deleteById(id);
	}

}
