package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.*;

import java.util.List;

public interface DissertacaoRepository extends JpaRepository<Dissertacao, Long> {

    Tese findByNrTese(float nrTese);

    Tese findByTema(Tema tema);

    List<Tese> findByNota(int nota);

    Tese findByAluno(Aluno aluno);

    List<Tese> findByDocente(Docente docente);

    @Query("SELECT p.tese FROM PropostaTese p WHERE p = :propostaTese")
    Tese findByPropostaTese(@Param("propostaTese") PropostaTese propostaTese);

}
