package fr.eni.bll;

import fr.eni.bo.Avis;
import fr.eni.bo.Film;
import fr.eni.bo.Genre;

import java.util.List;

public interface FilmService {

	Film trouverFilm(int id);
	List<Film> listerFilms();
	List<Genre> listerGenres();
	void ajouterFilm(Film f) throws BllException;
	void ajouterAvis(int idFilm, Avis av);
}
