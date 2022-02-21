package fr.eni.bo;

public class Membre {

	private int id;
	private String username;
	private String mail;
	private String password;
	boolean admin;

	public Membre() {
	}
	public Membre(String username, String mail, String password, boolean admin) {
		this.username = username;
		this.mail = mail;
		this.password = password;
		this.admin = admin;
	}

	public Membre(int id, String username, String mail, String password, boolean admin) {
		this.id = id;
		this.username = username;
		this.mail = mail;
		this.password = password;
		this.admin = admin;
	}


	public void copy(Membre m) {
		this.id = m.id;
		this.username = m.username;
		this.mail = m.mail;
		this.password = m.password;
		this.admin = m.admin;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Membre [id=" + id + ", username=" + username + ", mail=" + mail + ", password=" + password + ", admin="
				+ admin + "]";
	}
	
	
}
