package fr.eni.bll;

import fr.eni.bo.Membre;

public interface ConnexionService {

	Membre getMembre(String username, String password);
}
