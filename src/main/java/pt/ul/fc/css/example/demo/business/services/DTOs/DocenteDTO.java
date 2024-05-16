package pt.ul.fc.css.example.demo.business.services.DTOs;

import java.util.List;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.entities.Tese;

@Component
public class DocenteDTO {

  private long Id;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  private int nrDocente;

  private String nome;

  private List<Tese> teses;

  public int getNrDocente() {
    return nrDocente;
  }

  public void setNrDocente(int nrDocente) {
    this.nrDocente = nrDocente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Tese> getTeses() {
    return teses;
  }

  public void setTeses(List<Tese> teses) {
    this.teses = teses;
  }
}
