package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Utilizador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  @Column(unique = true)
  private int nrConta;

  private String nome;

  private String token;

  public Utilizador(int nrConta, String nome, String token) {
    this.nrConta = nrConta;
    this.nome = nome;
    this.token = token;
  }

  public Utilizador() {}

  public int getNrConta() {
    return nrConta;
  }

  public void setNrConta(int nrConta) {
    if (nrConta <= 0) throw new IllegalArgumentException("Account number must be positive");
    this.nrConta = nrConta;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
