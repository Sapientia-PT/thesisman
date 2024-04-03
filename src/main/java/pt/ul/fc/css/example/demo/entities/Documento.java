package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import pt.ul.fc.css.example.demo.datatypes.TipoDocumento;

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

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    public Documento(long nrDocumento, String nome, float nota, TipoDocumento tipoDocumento) {
        this.nrDocumento = nrDocumento;
        this.nome = nome;
        this.nota = nota;
        this.tipoDocumento = tipoDocumento;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
}
