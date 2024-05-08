package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrientadorExterno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "orientadorExterno")
    private List<Projeto> projetos;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public OrientadorExterno(List<Projeto> projetos, Empresa empresa) {
        this.projetos = projetos;
        this.empresa = empresa;
    }

    public OrientadorExterno() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
