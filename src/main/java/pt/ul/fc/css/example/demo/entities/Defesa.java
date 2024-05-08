package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Defesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private long nrDefesa;

    @OneToOne
    @JoinColumn(name = "documento_id")
    private Documento documento;

    public Defesa(long nrDefesa, Documento documento) {
        this.nrDefesa = nrDefesa;
        this.documento = documento;
    }

    public Defesa() {

    }

    public long getNrDefesa() {
        return nrDefesa;
    }

    public void setNrDefesa(long nrDefesa) {
        this.nrDefesa = nrDefesa;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
