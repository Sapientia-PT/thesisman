package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;
import org.springframework.lang.NonNull;

@Entity
public class Docente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(unique = true)
  private long nrDocente;

  private String nome;

  @OneToMany(mappedBy = "docente")
  private List<Tese> teses;

  public Docente(long nrDocente, @NonNull String nome, List<Tese> teses) {
    this.nrDocente = nrDocente;
    this.nome = nome;
    this.teses = teses;
  }

  public Docente() {}

  public long getNrDocente() {
    return nrDocente;
  }

  public void setNrDocente(long nrDocente) {
    this.nrDocente = nrDocente;
  }

  @NonNull
  public String getNome() {
    return nome;
  }

  public void setNome(@NonNull String nome) {
    this.nome = nome;
  }

  public List<Tese> getTeses() {
    return teses;
  }

  public void setTeses(List<Tese> teses) {
    this.teses = teses;
  }
}
