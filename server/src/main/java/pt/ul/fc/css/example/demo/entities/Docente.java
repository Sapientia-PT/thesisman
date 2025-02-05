package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * This class represents an docente entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Entity
public class Docente extends Utilizador {

  @OneToMany(mappedBy = "docente")
  private List<Tese> teses;

  @OneToMany(mappedBy = "arguente")
  private List<Juri> juriAsArguente;

  @OneToMany(mappedBy = "presidente")
  private List<Juri> juriAsPresidente;

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

  public List<Juri> getJuriAsArguente() {
    return juriAsArguente;
  }

  public void setJuriAsArguente(List<Juri> juriAsArguente) {
    this.juriAsArguente = juriAsArguente;
  }

  public List<Juri> getJuriAsPresidente() {
    return juriAsPresidente;
  }

  public void setJuriAsPresidente(List<Juri> juriAsPresidente) {
    this.juriAsPresidente = juriAsPresidente;
  }
}
