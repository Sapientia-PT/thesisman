package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public final class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private int nrAluno;

    @NonNull
    private String nome;

    private float media;

    @OneToOne(mappedBy = "aluno")
    private Tese tese;

    @OneToMany(mappedBy = "aluno")
    private List<Tema> temasEscolhidos;

    public Aluno(int nrAluno, @NonNull String nome, float media, Tese tese, List<Tema> temasEscolhidos) {
        this.nrAluno = nrAluno;
        this.nome = nome;
        this.media = media;
        this.tese = tese;
        this.temasEscolhidos = temasEscolhidos;
    }

    public Aluno() {
        this.temasEscolhidos = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Tema> getTemasEscolhidos() {
        return temasEscolhidos;
    }

    public void setTemasEscolhidos(List<Tema> temasEscolhidos) {
        this.temasEscolhidos = temasEscolhidos;
    }

    public int getNrAluno() {
        return nrAluno;
    }

    public void setNrAluno(int nrAluno) {
        if (nrAluno <= 0) {
            throw new IllegalArgumentException("nrAluno must be positive");
        }
        this.nrAluno = nrAluno;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Aluno) obj;
        return Objects.equals(this.nrAluno, that.nrAluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Aluno[" +
                "id=" + id + ", " +
                "nome=" + nome + ", " +
                "media=" + media + "]";
    }
}
