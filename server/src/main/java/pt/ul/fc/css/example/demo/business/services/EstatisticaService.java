package pt.ul.fc.css.example.demo.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.AlunosInfoHandler;

/**
 * This class reprents the Estatistica Service. Handles the logic for callin the AlunosInfoHandler
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Service
public class EstatisticaService {

  @Autowired private AlunosInfoHandler alunosInfoHandler;

  public int calcularNumeroAlunosAprovados() {
    return alunosInfoHandler.calcularNumeroAlunosAprovados();
  }

  public int calcularNumeroAlunosReprovados() {
    return alunosInfoHandler.calcularNumeroAlunosReprovados();
  }
}
