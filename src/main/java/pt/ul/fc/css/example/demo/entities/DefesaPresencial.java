package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pt.ul.fc.css.example.demo.datatypes.Regime;

@Entity
public class DefesaPresencial extends Defesa {

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    public DefesaPresencial(long nrDefesa, PropostaTese propostaTese, Regime regime, int duracaoMinutos, Sala sala, Juri juri) {
        super(nrDefesa, propostaTese, regime, duracaoMinutos, juri);
        this.sala = sala;
    }

    public DefesaPresencial() {

    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
