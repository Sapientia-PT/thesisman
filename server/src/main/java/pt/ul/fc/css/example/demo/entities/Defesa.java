package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Defesa {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne(mappedBy = "defesa")
  private PropostaTese propostaTese;

  @Column(nullable = false)
  private int duracaoMinutos;

  @Embedded private Horario horario;

  @ManyToOne
  @JoinColumn(name = "sala_id")
  private Sala sala;

  private int nota;

  @OneToOne(mappedBy = "defesa")
  private Juri juri;

  public Defesa(
      PropostaTese propostaTese, int duracaoMinutos, Horario horario, Sala sala, int nota) {
    this.propostaTese = propostaTese;
    this.duracaoMinutos = duracaoMinutos;
    this.horario = horario;
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

  public Horario getHorario() {
    return horario;
  }

  public void setHorario(Horario horario) {
    this.horario = horario;
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
}
