package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
  Administrador findByToken(String token);
}
