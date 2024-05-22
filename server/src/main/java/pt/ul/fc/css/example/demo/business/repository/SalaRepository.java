package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.Sala;

/**
 * This class reprents the Sala Repository.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
public interface SalaRepository extends JpaRepository<Sala, Long> {

  Sala findByNrSala(long nrSala);

  @Query("SELECT d.sala FROM Defesa d WHERE d = :defesa")
  Sala findByDefesa(@Param("defesa") Defesa defesa);
}
