package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import pt.ul.fc.css.example.demo.datatypes.Regime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Defesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private long nrDefesa;

    @OneToOne(mappedBy = "defesa")
    private PropostaTese propostaTese;

    @Enumerated(EnumType.STRING)
    private Regime regime;

    @Column(nullable = false)
    private int duracaoMinutos;

    @OneToOne
    @JoinColumn(name = "juri_id")
    private Juri juri;

    public Defesa(long nrDefesa, PropostaTese propostaTese, Regime regime, int duracaoMinutos, Juri juri) {
        this.nrDefesa = nrDefesa;
        this.propostaTese = propostaTese;
        this.regime = regime;
        this.duracaoMinutos = duracaoMinutos;
        this.juri = juri;
    }

    public Defesa() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNrDefesa() {
        return nrDefesa;
    }

    public void setNrDefesa(long nrDefesa) {
        this.nrDefesa = nrDefesa;
    }

    public PropostaTese getPropostaTese() {
        return propostaTese;
    }

    public void setPropostaTese(PropostaTese propostaTese) {
        this.propostaTese = propostaTese;
    }

    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public Juri getJuri() {
        return juri;
    }

    public void setJuri(Juri juri) {
        this.juri = juri;
    }
}
