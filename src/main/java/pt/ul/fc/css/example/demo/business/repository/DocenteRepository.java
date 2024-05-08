package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Long> {

    Docente findByNrDocente(long nrDocente);
    Docente findByNome(String nome);

}
