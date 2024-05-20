package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
public class Defesa {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne(mappedBy = "defesa")
  private PropostaTese propostaTese;

  @Column(nullable = false)
  private int duracaoMinutos;

  private Time hora;

  @ManyToOne
  @JoinColumn(name = "sala_id")
  private Sala sala;

  private int nota;

  @ManyToMany
  @JoinTable(
      name = "defesa_juri",
      joinColumns = @JoinColumn(name = "defesa_id"),
      inverseJoinColumns = @JoinColumn(name = "docente_id"))
  private List<Docente> juri;

  public Defesa(PropostaTese propostaTese, int duracaoMinutos, Time hora, Sala sala, int nota) {
    this.propostaTese = propostaTese;
    this.duracaoMinutos = duracaoMinutos;
    this.hora = hora;
    this.sala = sala;
    this.nota = nota;
  }

  public Defesa() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PropostaTese getPropostaTese() {
    return propostaTese;
  }

  public void setPropostaTese(PropostaTese propostaTese) {
    this.propostaTese = propostaTese;
  }

  public int getDuracaoMinutos() {
    return duracaoMinutos;
  }

  public void setDuracaoMinutos(int duracaoMinutos) {
    this.duracaoMinutos = duracaoMinutos;
  }

  public Time getHora() {
    return hora;
  }

  public void setHora(Time hora) {
    this.hora = hora;
  }

  public Sala getSala() {
    return sala;
  }

  public void setSala(Sala sala) {
    this.sala = sala;
  }

  public int getNota() {
    return nota;
  }

  public void setNota(int nota) {
    this.nota = nota;
  }

  public List<Docente> getJuri() {
    return juri;
  }

  public void setJuri(List<Docente> juri) {
    this.juri = juri;
  }
}
