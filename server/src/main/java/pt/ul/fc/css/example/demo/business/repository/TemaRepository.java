package pt.ul.fc.css.example.demo.business.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.ul.fc.css.example.demo.entities.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {

  @Query("SELECT t FROM Tema t WHERE t.titulo = ?1")
  Tema findByTitulo(String titulo);

  List<Tema> findByDescricao(String descricao);

  List<Tema> findByRemunMensal(float remunMensal);

  @Query("SELECT t FROM Tema t JOIN t.aluno a WHERE a.nrConta = ?1")
  List<Tema> findByNrAluno(int nrAluno);
}
