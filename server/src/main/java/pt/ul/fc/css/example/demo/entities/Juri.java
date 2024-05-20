package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Juri {

  @Id private Long id;

  @OneToOne private Defesa defesa;

  @ManyToOne
  @JoinColumn(name = "orientador_id")
  private Docente orientadorInterno;

  @ManyToOne
  @JoinColumn(name = "arguente_id")
  private Docente arguente;

  @ManyToOne
  @JoinColumn(name = "presidente_id")
  private Docente presidente;

  // Defesa de Tese (final)
  public Juri(Defesa defesa, Docente orientadorInterno, Docente arguente, Docente presidente) {
    this.defesa = defesa;
    this.orientadorInterno = orientadorInterno;
    this.arguente = arguente;
    this.presidente = presidente;
  }

  // Defesa de Proposta de Tese
  public Juri(Defesa defesa, Docente orientadorInterno, Docente arguente) {
    this.defesa = defesa;
    this.orientadorInterno = orientadorInterno;
    this.arguente = arguente;
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

  public Docente getOrientadorInterno() {
    return orientadorInterno;
  }

  public void setOrientadorInterno(Docente orientadorInterno) {
    this.orientadorInterno = orientadorInterno;
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
