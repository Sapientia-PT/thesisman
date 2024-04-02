package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import pt.ul.fc.css.example.demo.datatypes.EstadoAluno;

import java.util.Objects;

@Entity
public final class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @NonNull
    private int nrAluno;

    @NonNull
    private String nome;

    private float media;

    private EstadoAluno estadoAluno;

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

    public EstadoAluno getEstadoAluno() {
        return estadoAluno;
    }

    public void setEstadoAluno(EstadoAluno estadoAluno) {
        this.estadoAluno = estadoAluno;
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
        return Objects.hash(Id, nome);
    }

    @Override
    public String toString() {
        return "Aluno[" +
                "id=" + Id + ", " +
                "nome=" + nome + ", " +
                "media=" + media + ", " +
                "estado=" + estadoAluno + ']';
    }
}
