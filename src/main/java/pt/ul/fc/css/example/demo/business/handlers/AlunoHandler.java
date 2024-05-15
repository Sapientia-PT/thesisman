package pt.ul.fc.css.example.demo.business.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.entities.Aluno;

@Component
public class AlunoHandler {

  @Autowired private AlunoRepository alunoRepository;

  public Aluno createAluno(String nome, String token, int nrAluno, float media) {

    Aluno aluno = new Aluno();
    aluno.setNome(nome);
    aluno.setToken(token);
    aluno.setNrAluno(nrAluno);
    aluno.setMedia(media);

    return alunoRepository.save(aluno);
  }
}
