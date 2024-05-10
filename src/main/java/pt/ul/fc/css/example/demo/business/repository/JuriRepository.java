package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.*;

public interface JuriRepository extends JpaRepository<Juri, Long> {

    Juri findByDefesa(Defesa defesa);

    Juri findByOrientadorInterno(OrientadorInterno orientadorInterno);

    Juri findByArguente(Arguente arguente);

    Juri findByPresidente(Presidente presidente);

}
