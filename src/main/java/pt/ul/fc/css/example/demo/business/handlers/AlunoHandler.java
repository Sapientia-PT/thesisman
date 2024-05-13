package pt.ul.fc.css.example.demo.business.handlers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.entities.Aluno;

@Component
public class AlunoHandler {

  @Autowired private AlunoRepository alunoRepository;

  public Aluno createAluno(int nrAluno, String nome, float media) {

    Aluno aluno = new Aluno();
    aluno.setNrAluno(nrAluno);
    aluno.setNome(nome);
    aluno.setMedia(media);

    return alunoRepository.save(aluno);
  }

  public List<Aluno> getAlunos() {
    return alunoRepository.findAll();
  }
}
