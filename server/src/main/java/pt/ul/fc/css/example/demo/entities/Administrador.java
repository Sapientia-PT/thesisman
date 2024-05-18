package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Utilizador {

  public Administrador(int nrConta, String nome, String token) {
    super(nrConta, nome, token);
  }

  public Administrador() {
    super();
  }
}
