package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Docente extends Utilizador {

  @OneToMany(mappedBy = "docente")
  private List<Tese> teses;

  public Docente(int nrConta, String nome, String token, int nrDocente, List<Tese> teses) {
    super(nrConta, nome, token);
    this.teses = teses;
  }

  public Docente() {
    super();
  }

  public List<Tese> getTeses() {
    return teses;
  }

  public void setTeses(List<Tese> teses) {
    this.teses = teses;
  }
}
