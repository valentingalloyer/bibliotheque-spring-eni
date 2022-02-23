package fr.eni.bll;

import fr.eni.dal.EditeurDAO;
import fr.eni.entity.Editeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditeurServiceEnMemoire implements EditeurService {

    @Autowired
    EditeurDAO dao;

    @Override
    public Editeur trouverEditeur(Long id) throws BllException {
        Editeur editeur;
        if (dao.findById(id).isPresent()) {
            editeur = dao.findById(id).get();
        } else {
            throw new BllException("Editeur non trouvé");
        }
        return editeur;
    }

    @Override
    public List<Editeur> listerEditeurs() {
        return dao.findAll();
    }

    @Override
    public void ajouterEditeur(Editeur editeur) throws BllException {
        try {
            if (editeur == null) {
                throw new BllException("L'éditeur est null");
            } else {
                dao.save(editeur);
            }
        } catch (Exception e) {
            throw new BllException("Impossible d'avoir deux éditeurs du même nom");
        }
    }

    @Override
    public void modifierEditeur(Editeur editeur) throws BllException {
        try {
            if (editeur == null) {
                throw new BllException("L'éditeur est null");
            }
            if (editeur.getId() == null) {
                throw new BllException("L'éditeur à modifier n'existe pas");
            } else {
                dao.save(editeur);
            }
        } catch (Exception e) {
            throw new BllException("Impossible d'avoir deux éditeurs du même nom");
        }
    }

    @Override
    public void supprimerEditeur(Long id) throws BllException {
        try {
            dao.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new BllException("Impossible de supprimer un éditeur qui a déjà édité des livres");
        }

    }
}
