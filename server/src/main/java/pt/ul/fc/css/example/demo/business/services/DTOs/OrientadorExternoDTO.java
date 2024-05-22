package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.entities.Empresa;

/**
 * This class represents a DTO for an Orientador Externo enabling the secure data transfer between
 * endpoints.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class OrientadorExternoDTO {

  private long Id;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  private int nrEmpresario;

  private String nome;

  private Empresa empresa;

  public int getNrEmpresario() {
    return nrEmpresario;
  }

  public void setNrEmpresario(int nrEmpresario) {
    this.nrEmpresario = nrEmpresario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }
}
