package pt.ul.fc.css.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.datatypes.TipoTese;
import pt.ul.fc.css.example.demo.entities.Tema;
import pt.ul.fc.css.example.demo.entities.Tese;

import java.util.List;

public interface TeseRepository extends JpaRepository<Tese, Long> {

    Tese findByNrTese(float nrTese);

    Tese findByTema(Tema tema);

    List<Tese> findByNota(int nota);

    List<Tese> findByTipoTese(TipoTese tipoTese);

}
