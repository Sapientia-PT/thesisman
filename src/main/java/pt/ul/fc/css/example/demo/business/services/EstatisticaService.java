package pt.ul.fc.css.example.demo.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.AlunosAprovadosHandler;

@Service
public class EstatisticaService {

  @Autowired private AlunosAprovadosHandler alunosAprovadosHandler;

  public int calcularNumeroAlunosAprovados() {
    return alunosAprovadosHandler.calcularNumeroAlunosAprovados();
  }
}
