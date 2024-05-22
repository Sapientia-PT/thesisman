package pt.ul.fc.css.example.demo.business.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;

/**
 * This class reprents the handler for statistics.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class AlunosInfoHandler {

  @Autowired private AlunoRepository alunoRepository;

  public int calcularNumeroAlunosAprovados() {
    return alunoRepository.findAll().stream()
        .mapToInt(aluno -> aluno.getMedia() >= 10.0 ? 1 : 0)
        .sum();
  }

  public int calcularNumeroAlunosReprovados() {
    return alunoRepository.findAll().stream()
        .mapToInt(aluno -> aluno.getMedia() < 10.0 ? 1 : 0)
        .sum();
  }
}
