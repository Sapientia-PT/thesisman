package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.DefesaPresencial;
import pt.ul.fc.css.example.demo.entities.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    Sala findByNrSala(long nrSala);

    @Query("SELECT d.sala FROM DefesaPresencial d WHERE d = :defesaPresencial")
    Sala findByDefesaPresencial(@Param("defesaPresencial") DefesaPresencial defesaPresencial);

}
