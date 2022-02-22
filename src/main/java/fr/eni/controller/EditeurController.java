package fr.eni.controller;


import fr.eni.bll.BllException;
import fr.eni.bll.EditeurService;
import fr.eni.entity.Editeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/editeur")
public class EditeurController {

	@Autowired
	private EditeurService editeurService;

	@GetMapping("/lister")
	String lister(Model model) {
		model.addAttribute("listeE", editeurService.listerEditeurs());
		return "listeediteurs";
	}

	@GetMapping("/ajouter")
	String ajouterEditeur(Model model) {
		model.addAttribute("editeur", new Editeur());

		return "ajoutediteur";
	}

	@PostMapping("/ajouter")
	String ajouterEditeur(Model model, Editeur editeur) {
		System.out.println(editeur);
		try {
			editeurService.ajouterEditeur(editeur);
		} catch (BllException e) {
			model.addAttribute("editeur", editeur);
			model.addAttribute("erreur", e.getMessage());
			return "ajoutediteur";
		}

		return "redirect:/editeur/lister";
	}

	@GetMapping("/modifier/{id}")
	String modifier(Model model, @PathVariable long id) throws BllException {
		model.addAttribute("editeur", editeurService.trouverEditeur(id));

		return "modifierediteur";
	}

	@PostMapping("/modifier/{id}")
	String modifier(Model model, @PathVariable long id, @ModelAttribute Editeur editeur) throws BllException {
		Editeur e = editeurService.trouverEditeur(id);
		if (e == null) {
			return "redirect:/editeur/lister";
		}

		editeurService.modifierEditeur(editeur);

		return "redirect:/editeur/lister";
	}

	@GetMapping("/supprimer/{id}")
	String supprimer(Model model, @PathVariable long id) throws BllException {
		try {
			editeurService.supprimerEditeur(id);
		} catch (BllException e) {
			model.addAttribute("editeur", editeurService.trouverEditeur(id));
			model.addAttribute("erreur", e.getMessage());
		}

		return "redirect:/editeur/lister";
	}
	
}
