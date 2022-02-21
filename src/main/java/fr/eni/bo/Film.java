package fr.eni.bo;

import java.util.ArrayList;
import java.util.List;

public class Film {

	private int id;
	private String titre;
	private int annee;
	private int duree;
	private String synopsis;
	private Genre genre;
	private List<Avis> listeAvis;
	private List<Personne> acteurs;
	private Personne realisateur;

	public Film() {
		setAnnee(2000);
		
		setListeAvis(null);
		setActeurs(null);
	}
	public Film(String titre, int annee, int duree, String synopsis, Genre genre, List<Avis> listeAvis,
			List<Personne> acteurs, Personne realisateur) {
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.genre = genre;
		setListeAvis(listeAvis);
		setActeurs(acteurs);
		this.realisateur = realisateur;
	}

	public Film(int id, String titre, int annee, int duree, String synopsis, Genre genre, List<Avis> listeAvis,
			List<Personne> acteurs, Personne realisateur) {
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.genre = genre;
		setListeAvis(listeAvis);
		setActeurs(acteurs);
		this.realisateur = realisateur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getAnnee() {
		return annee;
	}
	
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public List<Avis> getListeAvis() {
		return listeAvis;
	}
	public void setListeAvis(List<Avis> listeAvis) {
		if (listeAvis != null)
			this.listeAvis = listeAvis;
		else
			this.listeAvis = new ArrayList<Avis>();
	}
	public List<Personne> getActeurs() {
		return acteurs;
	}
	public void setActeurs(List<Personne> acteurs) {
		if (acteurs != null)
			this.acteurs = acteurs;
		else
			this.acteurs = new ArrayList<Personne>();
	}
	public Personne getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(Personne realisateur) {
		this.realisateur = realisateur;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", annee=" + annee + ", duree=" + duree + ", synopsis="
				+ synopsis + ", genre=" + genre + ", listeAvis=" + listeAvis + ", acteurs=" + acteurs + ", realisateur="
				+ realisateur + "]";
	}
	
}
