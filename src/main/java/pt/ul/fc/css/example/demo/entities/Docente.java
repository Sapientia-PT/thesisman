package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Docente extends Utilizador {

  @Column(unique = true)
  private long nrDocente;

  @OneToMany(mappedBy = "docente")
  private List<Tese> teses;

  public Docente(String nome, String token, long nrDocente, List<Tese> teses) {
    super(nome, token);
    this.nrDocente = nrDocente;
    this.teses = teses;
  }

  public Docente() {
    super();
  }

  public long getNrDocente() {
    return nrDocente;
  }

  public void setNrDocente(long nrDocente) {
    this.nrDocente = nrDocente;
  }

  public List<Tese> getTeses() {
    return teses;
  }

  public void setTeses(List<Tese> teses) {
    this.teses = teses;
  }
}
