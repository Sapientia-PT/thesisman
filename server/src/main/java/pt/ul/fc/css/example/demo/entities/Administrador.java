package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;

/**
 * This class represents an administrator entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Entity
public class Administrador extends Utilizador {

  public Administrador(int nrConta, String nome, String token) {
    super(nrConta, nome, token);
  }

  public Administrador() {
    super();
  }
}
