package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String titulo;

    private String descricao;

    private float remunMensal;

    public Tema(@NonNull String titulo, String descricao, float remunMensal) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.remunMensal = remunMensal;
    }

    public Tema() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getRemunMensal() {
        return remunMensal;
    }

    public void setRemunMensal(float remunMensal) {
        this.remunMensal = remunMensal;
    }
}
