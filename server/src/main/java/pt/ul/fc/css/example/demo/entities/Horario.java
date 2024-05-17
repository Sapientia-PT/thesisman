package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.Objects;
import org.springframework.lang.NonNull;

@Entity
public class Horario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Time horaInicio;
  private Time horaFim;

  @ManyToOne
  @JoinColumn(name = "sala_id")
  private Sala sala;

  public Horario(@NonNull Time horaInicio, @NonNull Time horaFim, Sala sala) {
    this.horaInicio = horaInicio;
    this.horaFim = horaFim;
    this.sala = sala;
  }

  public Horario() {}

  @NonNull
  public Time getHoraInicio() {
    return horaInicio;
  }

  public void setHoraInicio(@NonNull Time horaInicio) {
    this.horaInicio = horaInicio;
  }

  @NonNull
  public Time getHoraFim() {
    return horaFim;
  }

  public void setHoraFim(@NonNull Time horaFim) {
    this.horaFim = horaFim;
  }

  public Sala getSala() {
    return sala;
  }

  public void setSala(Sala sala) {
    this.sala = sala;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Horario) obj;
    return Objects.equals(this.horaInicio, that.horaInicio)
        && Objects.equals(this.horaFim, that.horaFim)
        && Objects.equals(this.sala, that.sala);
  }

  @Override
  public int hashCode() {
    return Objects.hash(horaInicio, horaFim, sala);
  }

  @Override
  public String toString() {
    return "Horario["
        + "horaInicio="
        + horaInicio
        + ", "
        + "horaFim="
        + horaFim
        + ", "
        + "sala="
        + sala
        + ']';
  }
}
