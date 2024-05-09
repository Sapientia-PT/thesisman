package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.PropostaTese;
import pt.ul.fc.css.example.demo.entities.Tese;

import java.util.List;

public interface PropostaTeseRepository extends JpaRepository<PropostaTese, Long> {

    List<PropostaTese> findByTese(Tese tese);

    PropostaTese findByDefesa(Defesa defesa);

}
