package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class Mestrado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private long idMestrado;

    @Column(unique = true)
    @NonNull
    private String nome;

    public Mestrado(long idMestrado, @NonNull String nome) {
        this.idMestrado = idMestrado;
        this.nome = nome;
    }

    public Mestrado() {

    }

    public long getIdMestrado() {
        return idMestrado;
    }

    public void setIdMestrado(long idMestrado) {
        this.idMestrado = idMestrado;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }
}
