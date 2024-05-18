package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Docente;
import pt.ul.fc.css.example.demo.entities.Tese;

public interface DocenteRepository extends JpaRepository<Docente, Long> {

  Docente findByNrConta(long nrDocente);

  Docente findByNome(String nome);

  @Query("SELECT t.docente FROM Tese t WHERE t = :tese")
  Docente findByTese(@Param("tese") Tese tese);

  Docente findByToken(String token);
}
