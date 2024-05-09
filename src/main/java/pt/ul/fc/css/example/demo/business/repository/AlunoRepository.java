package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Aluno;
import pt.ul.fc.css.example.demo.entities.Tese;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByNrAluno(int nrAluno);

    List<Aluno> findByNome(String nome);

    List<Aluno> findByMedia(float media);

    @Query("SELECT t.aluno FROM Tese t WHERE t = :tese")
    Aluno findByTese(@Param("tese") Tese tese);

}
