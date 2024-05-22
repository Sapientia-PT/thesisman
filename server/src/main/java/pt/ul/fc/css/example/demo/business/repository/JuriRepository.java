package pt.ul.fc.css.example.demo.business.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.*;

/**
 * This class reprents the Juri Repository.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
public interface JuriRepository extends JpaRepository<Juri, Long> {

  Juri findByDefesa(Defesa defesa);

  List<Juri> findByArguente(Docente arguente);

  List<Juri> findByPresidente(Docente presidente);
}
