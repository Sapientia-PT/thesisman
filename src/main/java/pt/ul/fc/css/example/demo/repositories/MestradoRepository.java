package pt.ul.fc.css.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Mestrado;

public interface MestradoRepository extends JpaRepository<Mestrado, Long> {

    Mestrado findByIdMestrado(long idMestrado);

    Mestrado findByNome(String nome);

}
