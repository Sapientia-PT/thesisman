package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.sql.Time;
import java.util.List;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private long nrSala;

    @OneToMany(mappedBy = "sala")
    private List<Horario> horarios;

    public Sala(long nrSala, List<Horario> horarios) {
        this.nrSala = nrSala;
        this.horarios = horarios;
    }

    public Sala() {

    }

    public long getNrSala() {
        return nrSala;
    }

    public void setNrSala(long nrSala) {
        this.nrSala = nrSala;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
