package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public final class Aluno extends Utilizador {

  @Column(unique = true)
  private int nrAluno;

  private float media;

  @OneToOne(mappedBy = "aluno")
  private Tese tese;

  @OneToMany(mappedBy = "aluno")
  private List<Tema> temasCandidatados;

  public Aluno(
      String nome,
      String token,
      int nrAluno,
      float media,
      Tese tese,
      List<Tema> temasCandidatados) {
    super(nome, token);
    this.nrAluno = nrAluno;
    this.media = media;
    this.tese = tese;
    this.temasCandidatados = temasCandidatados;
  }

  public Aluno() {
    super();
    this.temasCandidatados = new ArrayList<>();
  }

  public List<Tema> getTemasCandidatados() {
    return temasCandidatados;
  }

  public void setTemasCandidatados(List<Tema> temasCandidatados) {
    this.temasCandidatados = temasCandidatados;
  }

  public int getNrAluno() {
    return nrAluno;
  }

  public void setNrAluno(int nrAluno) {
    if (nrAluno <= 0) {
      throw new IllegalArgumentException("nrAluno must be positive");
    }
    this.nrAluno = nrAluno;
  }

  public float getMedia() {
    return media;
  }

  public void setMedia(float media) {
    this.media = media;
  }

  public Tese getTese() {
    return tese;
  }

  public void setTese(Tese tese) {
    this.tese = tese;
  }
}
