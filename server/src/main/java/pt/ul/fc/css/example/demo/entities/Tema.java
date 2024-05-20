package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Tema {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(unique = true, nullable = false)
  private String titulo;

  private String descricao;

  private float remunMensal;

  @ManyToOne
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  public Tema(String titulo, String descricao, float remunMensal, Aluno aluno) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.remunMensal = remunMensal;
    this.aluno = aluno;
  }

  public Tema() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public float getRemunMensal() {
    return remunMensal;
  }

  public void setRemunMensal(float remunMensal) {
    this.remunMensal = remunMensal;
  }

  public Aluno getAluno() {
    return aluno;
  }

  public void setAluno(Aluno aluno) {
    this.aluno = aluno;
  }
}
