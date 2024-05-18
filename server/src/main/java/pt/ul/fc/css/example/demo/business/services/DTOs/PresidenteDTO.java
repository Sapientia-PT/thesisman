package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;

@Component
public class PresidenteDTO {
  private long Id;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  private int nrPresidente;

  private String nome;

  public int getNrPresidente() {
    return nrPresidente;
  }

  public void setNrPresidente(int nrPresidente) {
    this.nrPresidente = nrPresidente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
