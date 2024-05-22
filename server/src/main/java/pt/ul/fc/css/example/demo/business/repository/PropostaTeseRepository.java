package pt.ul.fc.css.example.demo.business.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.PropostaTese;
import pt.ul.fc.css.example.demo.entities.Tese;

/**
 * This class reprents the Proposta Tese Repository.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
public interface PropostaTeseRepository extends JpaRepository<PropostaTese, Long> {

  List<PropostaTese> findByTese(Tese tese);

  PropostaTese findByDefesa(Defesa defesa);
}
