package fr.eni.controller;


import fr.eni.bll.BllException;
import fr.eni.bll.EditeurService;
import fr.eni.entity.Editeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    String ajouterEditeur(@Valid Editeur editeur, BindingResult br, Model model) {
        if (!br.hasErrors()) {
            System.out.println(editeur);
            try {
                editeurService.ajouterEditeur(editeur);
            } catch (BllException e) {
                model.addAttribute("editeur", editeur);
                model.addAttribute("erreur", e.getMessage());
                return "ajoutediteur";
            }

            return "redirect:/editeur/lister";
        } else {
            System.out.println("Valid a échoué");
            model.addAttribute("editeur", editeur);
            return "ajoutediteur";
        }
    }

    @GetMapping("/modifier/{id}")
    String modifier(Model model, @PathVariable long id) throws BllException {
        model.addAttribute("editeur", editeurService.trouverEditeur(id));

        return "modifierediteur";
    }

    @PostMapping("/modifier/{id}")
    String modifier(@PathVariable long id, @Valid @ModelAttribute Editeur editeur, BindingResult br, Model model) throws BllException {
        if (!br.hasErrors()) {
            Editeur ed = editeurService.trouverEditeur(id);
            if (ed == null) {
                return "redirect:/editeur/lister";
            }
            try {
                editeurService.modifierEditeur(editeur);
            } catch (BllException e) {
                model.addAttribute("erreur", e.getMessage());
                model.addAttribute("editeur", editeur);
                return "modifierediteur";
            }

            return "redirect:/editeur/lister";
        } else {
            System.out.println("Valid a échoué");
            model.addAttribute("editeur", editeur);
            return "ajoutediteur";
        }
    }

    @GetMapping("/supprimer/{id}")
    String supprimer(Model model, @PathVariable long id, RedirectAttributes redirectAttributes) throws BllException {
        try {
            editeurService.supprimerEditeur(id);
        } catch (BllException e) {
            model.addAttribute("editeur", editeurService.trouverEditeur(id));
            redirectAttributes.addFlashAttribute("erreur", e.getMessage());
        }
        return "redirect:/editeur/lister";
    }

}
