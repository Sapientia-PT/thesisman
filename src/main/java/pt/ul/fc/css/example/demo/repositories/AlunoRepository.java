package pt.ul.fc.css.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.datatypes.EstadoAluno;
import pt.ul.fc.css.example.demo.entities.Aluno;

import java.util.List;

public interface AlunoRepository {

    Aluno findByNrAluno(int nrAluno);
    List<Aluno> findByNome(String nome);
    List<Aluno> findByEstadoAluno(EstadoAluno estadoAluno);
    List<Aluno> findByMedia(float media);

}
