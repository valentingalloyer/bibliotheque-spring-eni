package fr.eni.bo;

import java.util.List;

public class Catalogue {

	private int id;
	private List<Film> films;
	
	public Catalogue() {
	}

	public Catalogue(List<Film> films) {
		this.films = films;
	}

	public Catalogue(int id, List<Film> films) {
		this.id = id;
		this.films = films;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Catalogue [id=" + id + ", films=" + films + "]";
	}

}
