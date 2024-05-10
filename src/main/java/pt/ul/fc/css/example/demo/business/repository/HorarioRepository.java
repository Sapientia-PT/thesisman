package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Horario;
import pt.ul.fc.css.example.demo.entities.Sala;

import java.sql.Time;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @Query("SELECT h FROM Horario h WHERE h.horaInicio > :t")
    List<Horario> findAfterHora(@Param("t") Time t);

    @Query("SELECT h FROM Horario h WHERE h.horaInicio < :t")
    List<Horario> findBeforeHora(@Param("t") Time t);

    List<Horario> findBySala(Sala sala);
}
