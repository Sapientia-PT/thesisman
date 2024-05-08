package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Presidente {
    @Id
    private Long id;

    @OneToOne(mappedBy = "presidente")
    private Juri juri;

    private String nome;

    public Presidente(Juri juri, String nome) {
        this.juri = juri;
        this.nome = nome;
    }

    public Presidente() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Juri getJuri() {
        return juri;
    }

    public void setJuri(Juri juri) {
        this.juri = juri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
