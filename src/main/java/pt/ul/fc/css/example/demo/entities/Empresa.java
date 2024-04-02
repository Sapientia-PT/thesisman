package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(unique = true)
    private long nrEmpresa;

    @NonNull
    @Column(unique = true)
    private String nome;

    public Empresa(long nrEmpresa, @NonNull String nome) {
        this.nrEmpresa = nrEmpresa;
        this.nome = nome;
    }

    public Empresa() {

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
}
