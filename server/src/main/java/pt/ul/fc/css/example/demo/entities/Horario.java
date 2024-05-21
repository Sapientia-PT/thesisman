package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.sql.Time;

@Embeddable
public class Horario {

  private Time horaInicio;
  private Time horaFim;

  public Horario(Time horaInicio, Time horaFim) {
    this.horaInicio = horaInicio;
    this.horaFim = horaFim;
  }

  public Horario() {}

  public Time getHoraInicio() {
    return horaInicio;
  }

  public void setHoraInicio(Time horaInicio) {
    this.horaInicio = horaInicio;
  }

  public Time getHoraFim() {
    return horaFim;
  }

  public void setHoraFim(Time horaFim) {
    this.horaFim = horaFim;
  }
}
