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

  private Time dataInicio;
  private Time dataFim;

  public Horario(Time dataInicio, Time dataFim) {
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
  }

  public Horario() {}

  public Time getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Time data) {
    this.dataInicio = data;
  }

  public Time getDataFim() {
    return dataFim;
  }

  public void setDataFim(Time data) {
    this.dataFim = data;
  }

  public boolean equals(Horario h) {
    return this.dataInicio.equals(h.getDataInicio()) && this.dataFim.equals(h.getDataFim());
  }
}
