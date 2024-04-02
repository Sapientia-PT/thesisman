package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private long nrEmpresa;

    @NonNull
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
