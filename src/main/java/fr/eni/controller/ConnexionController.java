package fr.eni.controller;

import fr.eni.bll.ConnexionService;
import fr.eni.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ConnexionController {

	@Autowired
	private ConnexionService connexionService;

	@Autowired
	private Membre membre;
	
	@GetMapping("/connect")
	public String connecter(Model model) {
		Membre login = new Membre();
		model.addAttribute("login", login);
		return "connect";
	}
	
	@PostMapping("connect")
	public String connecterPost(@ModelAttribute("login") Membre login, Model model, RedirectAttributes redirectAttributes) {
		Membre membre = connexionService.getMembre(login.getUsername(), login.getPassword());
		if (membre != null) {
			this.membre.copy(membre);
			redirectAttributes.addFlashAttribute("message", "Connexion effectuée avec succès");
			return "index";
		}
		else {
			model.addAttribute("erreur", "Identification incorrecte");
			return "connect";
		}
	}
		

	@GetMapping("/deconnect")
	public String deconnecter(HttpSession sess, RedirectAttributes redirectAttributes) {
		sess.invalidate();
		redirectAttributes.addFlashAttribute("warning", "Déconnexion effectuée avec succès");

		return "index";
	}
	
	
}
