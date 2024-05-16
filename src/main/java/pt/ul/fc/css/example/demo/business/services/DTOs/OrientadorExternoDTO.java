package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.entities.Empresa;

@Component
public class OrientadorExternoDTO {

  private long Id;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  private String nome;

  private Empresa empresa;

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
