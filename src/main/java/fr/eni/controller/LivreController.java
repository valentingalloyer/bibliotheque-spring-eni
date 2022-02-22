package fr.eni.controller;

import fr.eni.bll.BllException;
import fr.eni.bll.LivreService;
import fr.eni.bo.Membre;
import fr.eni.entity.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivreController {
	
	@Autowired
	private LivreService livreService;
	
	@Autowired
	private Membre membre;
	
	@GetMapping({"/", "/index"})
	String accueil(@ModelAttribute String message) {
		return "connect";
	}

	@GetMapping("/lister")
	String lister(Model model) {
		model.addAttribute("listeL", livreService.listerLivres());
		return "listelivres";
	}


	@GetMapping("/afficher")
	String afficher(long id, Model model) throws BllException {
		String retour = "fichelivre";
		Livre l = livreService.trouverLivre(id);
		if (l == null) {
			model.addAttribute("erreur", "Aucun livre ne correspond à l'id " + id);
			model.addAttribute("listeL", livreService.listerLivres());
			retour = "listelivres";
		} else {
			model.addAttribute("livre", l);
		}

		return retour;
	}


	@GetMapping("/ajouter")
	String ajouter(Model model) {
		if (!membre.isAdmin()) {
			model.addAttribute("erreur", "Vous devez être admin pour ajouter un livre");
			return "index";
		}
		model.addAttribute("livre", new Livre());
		
		return "ajoutlivre";
	}

	@PostMapping("/ajouter")
	String ajouterPost(Model model, Livre livre) {
		System.out.println(livre);
		try {
			livreService.ajouterLivre(livre);
		} catch (BllException e) {
			model.addAttribute("livre", livre);
			model.addAttribute("erreur", e.getMessage());
			return "ajoutlivre";
		}

		return "redirect:/lister";
	}

	@GetMapping("/supprimer/{id}")
	String supprimer(Model model, @PathVariable long id) throws BllException {
		System.out.println(id);
		try {
			livreService.supprimerLivre(id);
		} catch (BllException e) {
			model.addAttribute("livre", livreService.trouverLivre(id));
			model.addAttribute("erreur", e.getMessage());
			return "ajoutlivre";
		}

		return "redirect:/lister";
	}

	@GetMapping("/modifier/{id}")
	String modifier(Model model, @PathVariable long id) throws BllException {
		if (!membre.isAdmin()) {
			model.addAttribute("erreur", "Vous devez être admin pour modifier un livre");
			return "index";
		}
		model.addAttribute("livre", livreService.trouverLivre(id));

		return "ajoutlivre";
	}

	@PostMapping("/modifier")
	String modifier(Model model, @ModelAttribute long id, @ModelAttribute Livre livre) throws BllException {
		Livre l = livreService.trouverLivre(id);
		if (l == null) {
			return "redirect:/lister";
		}

		livreService.modifierLivre(id, livre);

		return "redirect:/lister";
	}

//	@GetMapping("/ajouteravis/{id}")
//	String ajouterAvis (@PathVariable Integer id, Model model) {
//		Livre l = livreService.trouverLivre(id);
//		if (l == null) {
//			return "redirect:/lister";
//		}
//
//		model.addAttribute("livre", l);
//		model.addAttribute("avis", new Avis());
//
//		return "ajoutavis";
//	}
	
//	@PostMapping("/ajouteravis/{id}")
//	String ajouterAvisPost (@PathVariable Integer id, Model model, @ModelAttribute("avis") Avis avis) {
//		Livre l = livreService.trouverLivre(id);
//		if (l == null) {
//			return "redirect:/lister";
//		}
//
//		livreService.ajouterAvis(id, avis);
//
//		return "redirect:/lister";
//	}
	
}
