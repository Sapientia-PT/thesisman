package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Juri;
import pt.ul.fc.css.example.demo.entities.Presidente;

public interface PresidenteRepository extends JpaRepository<Presidente, Long> {

  Presidente findByNome(String nome);

  Presidente findByJuri(Juri juri);

  Presidente findByToken(String token);
}
