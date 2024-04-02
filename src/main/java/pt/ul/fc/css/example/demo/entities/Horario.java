package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.sql.Time;

@Entity
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private Time horaInicio;
    @NonNull
    private Time horaFim;

    @ManyToOne
    private Sala sala;

    public Horario(@NonNull Time horaInicio, @NonNull Time horaFim, Sala sala) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.sala = sala;
    }

    public Horario() {

    }

    @NonNull
    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(@NonNull Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    @NonNull
    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(@NonNull Time horaFim) {
        this.horaFim = horaFim;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
