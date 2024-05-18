package pt.ul.fc.css.example.demo.business.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Aluno;
import pt.ul.fc.css.example.demo.entities.Tese;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

  Aluno findByNrConta(int nrAluno);

  List<Aluno> findByNome(String nome);

  List<Aluno> findByMedia(float media);

  @Query("SELECT t.aluno FROM Tese t WHERE t = :tese")
  Aluno findByTese(@Param("tese") Tese tese);

  Aluno findByToken(String token);
}
