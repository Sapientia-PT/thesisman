package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Juri;
import pt.ul.fc.css.example.demo.entities.OrientadorInterno;

public interface OrientadorInternoRepository extends JpaRepository<OrientadorInterno, Long> {

    OrientadorInterno findByNome(String nome);

    OrientadorInterno findByJuri(Juri juri);

}
