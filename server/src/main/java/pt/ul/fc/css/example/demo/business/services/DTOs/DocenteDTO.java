package pt.ul.fc.css.example.demo.business.services.DTOs;

import java.util.List;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.entities.Tese;

/**
 * This class represents a DTO for an docente enabling the secure data transfer between endpoints.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
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
