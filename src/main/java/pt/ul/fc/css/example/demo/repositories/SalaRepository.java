package pt.ul.fc.css.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    Sala findByNrSala(long nrSala);

}
