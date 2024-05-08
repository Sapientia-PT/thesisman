package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Juri {

    @Id
    private Long id;

    @OneToOne(mappedBy = "juri")
    private Defesa defesa;

    @OneToOne
    @JoinColumn(name = "orientador_id")
    private OrientadorInterno orientadorInterno;

    @OneToOne
    @JoinColumn(name = "arguente_id")
    private Arguente arguente;

    @OneToOne
    @JoinColumn(name = "presidente_id")
    private Presidente presidente;

    public Juri(Defesa defesa, OrientadorInterno orientadorInterno, Arguente arguente, Presidente presidente) {
        this.defesa = defesa;
        this.orientadorInterno = orientadorInterno;
        this.arguente = arguente;
        this.presidente = presidente;
    }

    public Juri() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Defesa getDefesa() {
        return defesa;
    }

    public void setDefesa(Defesa defesa) {
        this.defesa = defesa;
    }

    public OrientadorInterno getOrientadorInterno() {
        return orientadorInterno;
    }

    public void setOrientadorInterno(OrientadorInterno orientadorInterno) {
        this.orientadorInterno = orientadorInterno;
    }

    public Arguente getArguente() {
        return arguente;
    }

    public void setArguente(Arguente arguente) {
        this.arguente = arguente;
    }

    public Presidente getPresidente() {
        return presidente;
    }

    public void setPresidente(Presidente presidente) {
        this.presidente = presidente;
    }
}
