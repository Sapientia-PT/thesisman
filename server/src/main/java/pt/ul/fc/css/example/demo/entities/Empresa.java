package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;
import org.springframework.lang.NonNull;

/**
 * This class represents an empresa entity.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Entity
public class Empresa {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(unique = true, nullable = false)
  private long nrEmpresa;

  @Column(unique = true)
  private String nome;

  @OneToMany(mappedBy = "empresa")
  private List<OrientadorExterno> orientadoresExternos;

  public Empresa(
      long nrEmpresa, @NonNull String nome, List<OrientadorExterno> orientadoresExternos) {
    this.nrEmpresa = nrEmpresa;
    this.nome = nome;
    this.orientadoresExternos = orientadoresExternos;
  }

  public Empresa() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getNrEmpresa() {
    return nrEmpresa;
  }

  public void setNrEmpresa(long nrEmpresa) {
    this.nrEmpresa = nrEmpresa;
  }

  @NonNull
  public String getNome() {
    return nome;
  }

  public void setNome(@NonNull String nome) {
    this.nome = nome;
  }

  public List<OrientadorExterno> getOrientadoresExternos() {
    return orientadoresExternos;
  }

  public void setOrientadoresExternos(List<OrientadorExterno> orientadoresExternos) {
    this.orientadoresExternos = orientadoresExternos;
  }
}
