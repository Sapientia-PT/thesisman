package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.entities.Tema;
import pt.ul.fc.css.example.demo.entities.Tese;

import java.util.List;

@Component
public class AlunoDTO {

    private long Id;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    private int nrAluno;

    private String nome;

    private float media;

    private Tese tese;

    private List<Tema> temasEscolhidos;

    public int getNrAluno() {
        return nrAluno;
    }

    public void setNrAluno(int nrAluno) {
        this.nrAluno = nrAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public Tese getTese() {
        return tese;
    }

    public void setTese(Tese tese) {
        this.tese = tese;
    }

    public List<Tema> getTemasEscolhidos() {
        return temasEscolhidos;
    }

    public void setTemasEscolhidos(List<Tema> temasEscolhidos) {
        this.temasEscolhidos = temasEscolhidos;
    }
}
