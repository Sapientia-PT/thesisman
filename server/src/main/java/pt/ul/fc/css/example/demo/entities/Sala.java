package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Sala {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(unique = true, nullable = false)
  private long nrSala;

  @OneToMany(mappedBy = "sala")
  private List<Horario> horarios;

  @OneToMany(mappedBy = "sala")
  private List<Defesa> defesas;

  public Sala(long nrSala, List<Horario> horarios, List<Defesa> defesas) {
    this.nrSala = nrSala;
    this.horarios = horarios;
    this.defesas = defesas;
  }

  public Sala() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getNrSala() {
    return nrSala;
  }

  public void setNrSala(long nrSala) {
    this.nrSala = nrSala;
  }

  public List<Horario> getHorarios() {
    return horarios;
  }

  public void setHorarios(List<Horario> horarios) {
    this.horarios = horarios;
  }

  public List<Defesa> getDefesas() {
    return defesas;
  }

  public void setDefesas(List<Defesa> defesas) {
    this.defesas = defesas;
  }
}
