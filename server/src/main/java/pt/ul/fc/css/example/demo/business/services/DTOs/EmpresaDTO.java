package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;

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
