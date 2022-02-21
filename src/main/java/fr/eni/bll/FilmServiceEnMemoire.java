package fr.eni.bll;

import fr.eni.bo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceEnMemoire implements FilmService{

	@Autowired
	Catalogue catalogue;
	
	@Autowired
	List<Genre> listeGenres;

	@Autowired
	private Membre membre;
	
	@Autowired
	private ConnexionService connexionService;

	@Override
	public Film trouverFilm(int id) {
		Film trouve = null;
		for(Film f : catalogue.getFilms()) {
			if (f.getId() == id) {
				trouve = f;
				break;
			}
		}
		return trouve;
	}

	@Override
	public List<Film> listerFilms() {
		return catalogue.getFilms();
	}

	@Override
	public List<Genre> listerGenres() {
		return listeGenres;
	}

	@Override
	public void ajouterFilm(Film f) throws BllException {
		if (f == null) {
			throw new BllException("Le film est null");
		}
		
		if (f != null) {
			if (f.getTitre() == null || f.getTitre().trim().isEmpty()) {
				throw new BllException("Le titre est obligatoire");
			}
			if (f.getRealisateur() == null || f.getRealisateur().getNom() == null || f.getRealisateur().getNom().isEmpty()) {
				throw new BllException("Le nom du réalisateur est obligatoire");
			}
			int id = dernierId() + 1;
			f.setId(id);
			
			// trouver le genre
			
			Genre g = trouverGenre(f.getGenre().getId());
			if (g == null) {
				throw new BllException("Le genre est obligatoire");
			}
			else {
				f.setGenre(g);
			}
		}
		catalogue.getFilms().add(f);
	}

	@Override
	public void ajouterAvis(int idFilm, Avis av) {
		Film f = trouverFilm(idFilm);
		if (f != null) {
			av.setAuteur(connexionService.getMembre(membre.getUsername(), membre.getPassword()));
			f.getListeAvis().add(av);
		}
	}

	
	
	
	private int dernierId() {
		return catalogue.getFilms().get(catalogue.getFilms().size() - 1).getId();
	}

	private Genre trouverGenre(int id) {
		Genre trouve = null;
		for (Genre g : listeGenres) {
			if (g.getId() == id) {
				trouve = g;
				break;
			}
		}
		return trouve;
	}
}
