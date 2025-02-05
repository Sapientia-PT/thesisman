package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;

/**
 * This class represents an PropostaTese entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Entity
public class PropostaTese {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "tese_id")
  private Tese tese;

  @OneToOne
  @JoinColumn(name = "defesa_id")
  private Defesa defesa;

  public PropostaTese(Tese tese, Defesa defesa) {
    this.tese = tese;
    this.defesa = defesa;
  }

  public PropostaTese() {}

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public Tese getTese() {
    return tese;
  }

  public void setTese(Tese tese) {
    this.tese = tese;
  }

  public Defesa getDefesa() {
    return defesa;
  }

  public void setDefesa(Defesa defesa) {
    this.defesa = defesa;
  }
}
