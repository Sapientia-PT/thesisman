package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;

/**
 * This class represents an Projeto entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Entity
public class Projeto extends Tese {

  @ManyToOne
  @JoinColumn(name = "orientador_id")
  OrientadorExterno orientadorExterno;

  public Projeto(
      int nota,
      Tema tema,
      Aluno aluno,
      Docente docente,
      List<PropostaTese> propostasTese,
      OrientadorExterno orientadorExterno) {
    super(nota, tema, aluno, docente, propostasTese);
    this.orientadorExterno = orientadorExterno;
  }

  public Projeto() {}

  public OrientadorExterno getOrientadorExterno() {
    return orientadorExterno;
  }

  public void setOrientadorExterno(OrientadorExterno orientadorExterno) {
    this.orientadorExterno = orientadorExterno;
  }
}
