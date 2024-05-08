package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Projeto extends Tese {

    @ManyToOne
    @JoinColumn(name = "orientador_id")
    OrientadorExterno orientadorExterno;

    public Projeto(float nrTese, int nota, Tema tema, Aluno aluno, Docente docente, List<PropostaTese> propostasTese, OrientadorExterno orientadorExterno) {
        super(nrTese, nota, tema, aluno, docente, propostasTese);
        this.orientadorExterno = orientadorExterno;
    }

    public Projeto() {

    }
}
