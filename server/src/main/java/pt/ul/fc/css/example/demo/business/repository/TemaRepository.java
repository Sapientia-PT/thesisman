package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Tema;

import java.util.List;

public interface TemaRepository extends JpaRepository<Tema, Long> {

    List<Tema> findByTitulo(String titulo);

    List<Tema> findByDescricao(String descricao);

    List<Tema> findByRemunMensal(float remunMensal);

}
