package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an tese entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tese {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private int nota;

  @OneToOne
  @JoinColumn(name = "tema_id")
  private Tema tema;

  @OneToOne
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  @ManyToOne
  @JoinColumn(name = "docente_id")
  private Docente docente;

  @OneToMany(mappedBy = "tese")
  private List<PropostaTese> propostasTese;

  public Tese(int nota, Tema tema, Aluno aluno, Docente docente, List<PropostaTese> propostasTese) {
    this.nota = nota;
    this.tema = tema;
    this.aluno = aluno;
    this.docente = docente;
    this.propostasTese = propostasTese;
  }

  public Tese() {
    this.propostasTese = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Tema getTema() {
    return tema;
  }

  public void setTema(Tema tema) {
    this.tema = tema;
  }

  public Aluno getAluno() {
    return aluno;
  }

  public void setAluno(Aluno aluno) {
    this.aluno = aluno;
  }

  public Docente getDocente() {
    return docente;
  }

  public void setDocente(Docente docente) {
    this.docente = docente;
  }

  public List<PropostaTese> getPropostasTese() {
    return propostasTese;
  }

  public void setPropostasTese(List<PropostaTese> propostasTese) {
    this.propostasTese = propostasTese;
  }

  public int getNota() {
    return nota;
  }

  public void setNota(int nota) {
    this.nota = nota;
  }
}
