package fr.eni.dal;

import fr.eni.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreDAO extends JpaRepository<Livre, Long> {



}
