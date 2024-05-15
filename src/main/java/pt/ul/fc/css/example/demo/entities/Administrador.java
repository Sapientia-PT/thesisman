package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Utilizador {

  public Administrador(String nome, String token) {
    super(nome, token);
  }

  public Administrador() {
    super();
  }
}
