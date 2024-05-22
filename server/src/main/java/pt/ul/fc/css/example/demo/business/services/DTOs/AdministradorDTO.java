package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;

/**
 * This class represents a DTO for an administrator enabling the secure data transfer between
 * endpoints.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class AdministradorDTO {

  private long Id;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  private int nrAdministrador;

  private String nome;

  public int getNrAdministrador() {
    return nrAdministrador;
  }

  public void setNrAdministrador(int nrAdministrador) {
    this.nrAdministrador = nrAdministrador;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
