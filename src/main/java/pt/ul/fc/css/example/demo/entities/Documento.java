package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(unique = true)
    private long nrDocumento;

    private String nome;

    private float nota;

    public Documento(long nrDocumento, String nome, float nota) {
        this.nrDocumento = nrDocumento;
        this.nome = nome;
        this.nota = nota;
    }

    public Documento() {

    }

    public long getNrDocumento() {
        return nrDocumento;
    }

    public void setNrDocumento(long nrDocumento) {
        this.nrDocumento = nrDocumento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
