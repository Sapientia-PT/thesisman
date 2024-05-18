package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Presidente extends Utilizador {

  @OneToOne(mappedBy = "presidente")
  private Juri juri;

  public Presidente(Juri juri, int nrConta, String nome, String token) {
    super(nrConta, nome, token);
    this.juri = juri;
  }

  public Presidente() {
    super();
  }

  public Juri getJuri() {
    return juri;
  }

  public void setJuri(Juri juri) {
    this.juri = juri;
  }
}
