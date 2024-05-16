package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Docente extends Utilizador {

  @Column(unique = true)
  private int nrDocente;

  @OneToMany(mappedBy = "docente")
  private List<Tese> teses;

  public Docente(String nome, String token, int nrDocente, List<Tese> teses) {
    super(nome, token);
    this.nrDocente = nrDocente;
    this.teses = teses;
  }

  public Docente() {
    super();
  }

  public int getNrDocente() {
    return nrDocente;
  }

  public void setNrDocente(int nrDocente) {
    this.nrDocente = nrDocente;
  }

  public List<Tese> getTeses() {
    return teses;
  }

  public void setTeses(List<Tese> teses) {
    this.teses = teses;
  }
}
