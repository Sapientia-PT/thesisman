package pt.ul.fc.css.example.demo.business.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.PropostaTese;

/**
 * This class reprents the Defesa Repository.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
public interface DefesaRepository extends JpaRepository<Defesa, Long> {

  @Query("SELECT p.defesa FROM PropostaTese p where p = :propostaTese")
  Defesa findByPropostaTese(@Param("propostaTese") PropostaTese propostaTese);

  List<Defesa> findByDuracaoMinutos(int duracaoMinutos);
}
