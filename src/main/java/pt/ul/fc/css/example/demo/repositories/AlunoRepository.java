package pt.ul.fc.css.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByNrAluno(int nrAluno);
    List<Aluno> findByNome(String nome);
    List<Aluno> findByMedia(float media);

}
