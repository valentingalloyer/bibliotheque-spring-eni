package fr.eni.bll;

import fr.eni.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConnexionServiceEnMemoire implements ConnexionService {

	@Autowired
	@Qualifier("membres")
	List<Membre> membres;
	
	@Override
	public Membre getMembre(String username, String password) {
		Membre trouve = null;
		for (Membre membre : membres) {
			if (membre.getUsername().equals(username) && membre.getPassword().equals(password)) {
				trouve = membre;
				break;
			}
		}
		return trouve;
	}

}
