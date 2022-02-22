package fr.eni.bo;

import fr.eni.entity.Livre;

import java.util.List;

public class CatalogueLivre {

	private int id;
	private List<Livre> livres;

	public CatalogueLivre() {
	}

	public CatalogueLivre(List<Livre> livres) {
		this.livres = livres;
	}

	public CatalogueLivre(int id, List<Livre> livres) {
		this.id = id;
		this.livres = livres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Catalogue [id=" + id + ", livres=" + livres + "]";
	}

}
