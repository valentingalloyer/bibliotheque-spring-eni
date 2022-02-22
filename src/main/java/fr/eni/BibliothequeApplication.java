package fr.eni;

import fr.eni.dal.EditeurDAO;
import fr.eni.dal.LivreDAO;
import fr.eni.entity.Editeur;
import fr.eni.entity.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliothequeApplication implements CommandLineRunner {

	@Autowired
	LivreDAO livreDAO;

    @Autowired
    EditeurDAO editeurDAO;

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Editeur ed1 = new Editeur("Flammarion");
        Editeur ed2 = new Editeur("Hachette");
        Editeur ed3 = new Editeur("Michel Lafont");

        Livre hp1 = new Livre("Harry Potter à l'école des sorciers", "J. K. Rowling", true, "9780439362139", "Harry Potter, le bébé survivant, a vaincu Voldemort, le sorcier noir. Élevé chez son moldu d'oncle qui le martyrise, sans connaître ses origines, il se retrouve propulsé à 11 ans dans un monde magique, celui des sorciers dont il fait parti.", 657, ed1);
		Livre hp2 = new Livre("Harry Potter et la Chambre des secrets", "J. K. Rowling", false, "207058464X", "Cette deuxième année à l'école des sorciers ne s'annonce pas de tout repos ! Entre les cours de potions magiques, les matchs de Quidditch et les combats de mauvais sorts", 780, ed1);
		Livre ast = new Livre("Astérix et Cléopâtre", "René Goscinny", true, "9780340042397", "Cléopâtre fait le pari de construire un palais en un temps record afin de montrer à César la grandeur du peuple égyptien.", 68, ed2);

        editeurDAO.save(ed1);
        editeurDAO.save(ed2);
        editeurDAO.save(ed3);
		livreDAO.save(hp1);
		livreDAO.save(hp2);
		livreDAO.save(ast);

    }
}
