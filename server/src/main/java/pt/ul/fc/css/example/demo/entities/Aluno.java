package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public final class Aluno extends Utilizador {

  private float media;

  @OneToOne(mappedBy = "aluno")
  private Tese tese;

  @OneToMany(mappedBy = "aluno")
  private List<Tema> temasCandidatados;

  public Aluno(
      int nrConta,
      String nome,
      String token,
      float media,
      Tese tese,
      List<Tema> temasCandidatados) {
    super(nrConta, nome, token);
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
