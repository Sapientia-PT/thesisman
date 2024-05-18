package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class OrientadorExterno extends Utilizador {

  @OneToMany(mappedBy = "orientadorExterno")
  private List<Projeto> projetos;

  @ManyToOne
  @JoinColumn(name = "empresa_id")
  private Empresa empresa;

  public OrientadorExterno(
      int nrConta, String nome, String token, List<Projeto> projetos, Empresa empresa) {
    super(nrConta, nome, token);
    this.projetos = projetos;
    this.empresa = empresa;
  }

  public OrientadorExterno() {
    super();
  }

  public List<Projeto> getProjetos() {
    return projetos;
  }

  public void setProjetos(List<Projeto> projetos) {
    this.projetos = projetos;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }
}
