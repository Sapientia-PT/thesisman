package pt.ul.fc.css.example.demo.business.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Empresa;
import pt.ul.fc.css.example.demo.entities.OrientadorExterno;
import pt.ul.fc.css.example.demo.entities.Projeto;

/**
 * This class reprents the Orientador Externo Repository.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
public interface OrientadorExternoRepository extends JpaRepository<OrientadorExterno, Long> {

  OrientadorExterno findByNrConta(long nrOrientadorExterno);

  @Query("SELECT e.orientadoresExternos FROM Empresa e WHERE e = :empresa")
  List<OrientadorExterno> findByEmpresa(@Param("empresa") Empresa empresa);

  @Query("SELECT p.orientadorExterno FROM Projeto p WHERE p = :projeto")
  OrientadorExterno findByProjeto(@Param("projeto") Projeto projeto);

  OrientadorExterno findByToken(String token);
}
