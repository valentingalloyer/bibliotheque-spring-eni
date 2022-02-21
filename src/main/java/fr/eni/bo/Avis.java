package fr.eni.bo;

public class Avis {

	private int id;
	private String avis;
	private int note;

	private Membre auteur;

	public Avis() {
	}

	public Avis(String avis, int note, Membre auteur) {
		this.avis = avis;
		this.note = note;
		this.auteur = auteur;
	}

	public Avis(int id, String avis, int note, Membre auteur) {
		this.id = id;
		this.avis = avis;
		this.note = note;
		this.auteur = auteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Membre getAuteur() {
		return auteur;
	}

	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", avis=" + avis + ", note=" + note + ", auteur=" + auteur + "]";
	}

}
