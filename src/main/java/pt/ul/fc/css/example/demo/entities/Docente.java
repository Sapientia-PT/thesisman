package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(unique = true)
    private long nrDocente;

    @NonNull
    private String nome;

    public Docente(long nrDocente, @NonNull String nome) {
        this.nrDocente = nrDocente;
        this.nome = nome;
    }

    public Docente() {

    }

    public long getNrDocente() {
        return nrDocente;
    }

    public void setNrDocente(long nrDocente) {
        this.nrDocente = nrDocente;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }
}
