package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 * This class represents an juri entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Entity
public class Juri {

  @Id private Long id;

  @OneToOne private Defesa defesa;

  @ManyToOne
  @JoinColumn(name = "arguente_id")
  private Docente arguente;

  @ManyToOne
  @JoinColumn(name = "presidente_id")
  private Docente presidente;

  public Juri(Defesa defesa, Docente arguente, Docente presidente) {
    this.defesa = defesa;
    this.arguente = arguente;
    this.presidente = presidente; // it can be null
  }

  public Juri() {}

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public Defesa getDefesa() {
    return defesa;
  }

  public void setDefesa(Defesa defesa) {
    this.defesa = defesa;
  }

  public Docente getArguente() {
    return arguente;
  }

  public void setArguente(Docente arguente) {
    this.arguente = arguente;
  }

  public Docente getPresidente() {
    return presidente;
  }

  public void setPresidente(Docente presidente) {
    this.presidente = presidente;
  }
}
