package fr.eni.configuration;

import fr.eni.bo.*;
import fr.eni.entity.Livre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {

	@Bean
	List<Genre> getGenres(){
		List<Genre> liste = new ArrayList<Genre>();
		liste.add(new Genre(1, "Comédie"));
		liste.add(new Genre(2, "Policier"));
		liste.add(new Genre(3, "Thriller"));
		liste.add(new Genre(4, "Drame"));
		liste.add(new Genre(5, "Comédie dramatique"));
		liste.add(new Genre(6, "Sci-Fi"));
		
		return liste;
	}

	@Bean
	CatalogueLivre getLivres() {
		CatalogueLivre c = new CatalogueLivre();
		List<Livre> listeLivre = new ArrayList<>() {{
			add(new Livre("Harry Potter à l'école des sorciers", "J. K. Rowling", true, "9780439362139", "Harry Potter est un garçon ordinaire. ... Harry Potter, le bébé survivant, a vaincu Voldemort, le sorcier noir. Élevé chez son moldu d'oncle qui le martyrise, sans connaître ses origines, il se retrouve propulsé à 11 ans dans un monde magique, celui des sorciers dont il fait parti.", 657));
			add(new Livre("Harry Potter et la Chambre des secrets", "J. K. Rowling", false, "207058464X", "Une rentrée fracassante en voiture volante, une étrange malédiction quis'abat sur les élèves, cette deuxième année à l'école des sorciers ne s'annonce pas de tout repos ! Entre les cours de potions magiques, les matchs de Quidditch et les combats de mauvais sorts, Harry et ses amis Ron et Hermione trouveront-ils le temps de percer le mystère de la Chambre des Secrets ?", 780));
			add(new Livre("Astérix et Cléopâtre", "René Goscinny", true, "9780340042397", "Cléopâtre fait le pari de construire un palais en un temps record afin de montrer à César la grandeur du peuple égyptien.", 68));
		}};

		c.setLivres(listeLivre);

		return c;
	}
	
	@Bean
	Catalogue getCatalogue() {
		Catalogue c = new Catalogue();
		List<Genre> listeG = getGenres();
		
		List<Personne> acteurs1 = new ArrayList<Personne>();
		acteurs1.add(new Personne("Belmondo", "Jean-Paul"));
		acteurs1.add(new Personne("Anconina", "Richard"));
		acteurs1.add(new Personne("L.", "Marie-Sophie"));
		Film f1 = new Film(1, "Itinéraire d'un enfant gâté", 
							1988, 
							125, 
							"Après avoir brillamment réussi dans la vie, un homme de cinquante ans se retire secrètement et part à l'aventure.", 
							listeG.get(4), 
							new ArrayList<Avis>(), 
							acteurs1, 
							new Personne("Lelouch", "Claude"));
		
		List<Film> listeF = new ArrayList<Film>();
		listeF.add(f1);
		
		
		List<Personne> acteurs2 = new ArrayList<Personne>();
		acteurs2.add(new Personne("Chabat", "Alain"));
		acteurs2.add(new Personne("Lauby", "Chantal"));
		acteurs2.add(new Personne("Farrugia", "Dominique"));
		acteurs2.add(new Personne("Darmon", "Gérard"));
		Film f2 = new Film(2, "La Cité de la peur", 
							1994, 
							119, 
							"Odile Deray, attachée de presse, vient au Festival de Cannes pour présenter le film `Red is Dead'. Malheureusement, celui-ci est d'une telle faiblesse que personne ne souhaite en faire l'écho. Cependant, lorsque les projectionnistes du long-métrage en question meurent chacun leur tour dans d'étrange ...", 
							listeG.get(0), 
							new ArrayList<Avis>(), 
							acteurs2, 
							new Personne("Berberian", "Alain"));
		
		listeF.add(f2);
		c.setFilms(listeF);
		return c;
	}

	@Bean
	List<Membre> membres(){
		List<Membre> liste = new ArrayList<Membre>();
		liste.add(new Membre(1, "user", "user@mail.com", "user", false));
		liste.add(new Membre(2, "admin", "admin@mail.com", "admin", true));
		return liste;
	}

	@Bean
	@SessionScope()
	Membre membre(){
		return new Membre();
	}
}
