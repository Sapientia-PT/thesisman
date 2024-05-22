package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Administrador;

/**
 * This class reprents the Administrator Repository.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

  Administrador findByNrConta(long nrAdministrador);

  Administrador findByToken(String token);
}
