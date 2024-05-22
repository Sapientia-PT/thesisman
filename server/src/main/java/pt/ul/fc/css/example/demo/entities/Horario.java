package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.sql.Time;

/**
 * This class represents an horario entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Embeddable
public class Horario {

  private Time dataInicial;
  private Time dataFinal;

  public Horario(Time dataInicial, Time dataFinal) {
    this.dataInicial = dataInicial;
    this.dataFinal = dataFinal;
  }

  public Horario() {}

  public Time getDataInicial() {
    return dataInicial;
  }

  public void setDataInicial(Time data) {
    this.dataInicial = data;
  }

  public Time getDataFinal() {
    return dataFinal;
  }

  public void setDataFinal(Time data) {
    this.dataFinal = data;
  }

  public boolean equals(Horario h) {
    return this.dataInicial.equals(h.getDataInicial()) && this.dataFinal.equals(h.getDataFinal());
  }
}
