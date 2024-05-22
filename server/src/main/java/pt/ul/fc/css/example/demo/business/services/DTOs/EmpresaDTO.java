package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;

/**
 * This class represents a DTO for an empresa enabling the secure data transfer between endpoints.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class EmpresaDTO {

  private long Id;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  private String nome;

  private long nrEmpresa;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public long getNrEmpresa() {
    return nrEmpresa;
  }

  public void setNrEmpresa(long nrEmpresa) {
    this.nrEmpresa = nrEmpresa;
  }
}
