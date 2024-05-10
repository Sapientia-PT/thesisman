package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Arguente;
import pt.ul.fc.css.example.demo.entities.Juri;

public interface ArguenteRepository extends JpaRepository<Arguente, Long> {

    Arguente findByNome(String nome);

    Arguente findByJuri(Juri juri);

}
