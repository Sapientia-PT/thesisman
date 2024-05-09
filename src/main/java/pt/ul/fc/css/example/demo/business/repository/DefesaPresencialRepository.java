package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.datatypes.Regime;
import pt.ul.fc.css.example.demo.entities.*;

import java.util.List;

public interface DefesaPresencialRepository extends JpaRepository<DefesaPresencial, Long> {

    Defesa findByNrDefesa(long nrDefesa);

    @Query("SELECT p.defesa FROM PropostaTese p where p = :propostaTese")
    Defesa findByPropostaTese(@Param("propostaTese") PropostaTese propostaTese);

    List<Defesa> findByRegime(Regime regime);

    List<Defesa> findByDuracaoMinutos(int duracaoMinutos);

    Defesa findByJuri(Juri juri);

    @Query("SELECT s.defesasPresenciais FROM Sala s WHERE s = :sala")
    List<DefesaPresencial> findBySala(@Param("sala") Sala sala);

}
