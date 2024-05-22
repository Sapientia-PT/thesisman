package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * This class represents an sala entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Entity
public class Sala {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(unique = true, nullable = false)
  private long nrSala;

  @OneToMany(mappedBy = "sala")
  private List<Defesa> defesas;

  public Sala(long nrSala, List<Defesa> defesas) {
    this.nrSala = nrSala;
    this.defesas = defesas;
  }

  public Sala() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getNrSala() {
    return nrSala;
  }

  public void setNrSala(long nrSala) {
    this.nrSala = nrSala;
  }

  public List<Defesa> getDefesas() {
    return defesas;
  }

  public void setDefesas(List<Defesa> defesas) {
    this.defesas = defesas;
  }
}
