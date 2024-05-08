package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import pt.ul.fc.css.example.demo.datatypes.TipoTese;

import java.util.List;

@Entity
public class Tese {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private float nrTese;

    @OneToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    private int nota;

    @OneToMany(mappedBy = "tese")
    private List<Documento> documentos;

    @Enumerated(EnumType.STRING)
    private TipoTese tipoTese;

    public Tese(float nrTese, Tema tema, int nota, List<Documento> documentos, TipoTese tipoTese) {
        this.nrTese = nrTese;
        this.tema = tema;
        this.nota = nota;
        this.documentos = documentos;
        this.tipoTese = tipoTese;
    }

    public Tese() {

    }

    public float getNrTese() {
        return nrTese;
    }

    public void setNrTese(float nrTese) {
        this.nrTese = nrTese;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public TipoTese getTipoTese() {
        return tipoTese;
    }

    public void setTipoTese(TipoTese tipoTese) {
        this.tipoTese = tipoTese;
    }

}
