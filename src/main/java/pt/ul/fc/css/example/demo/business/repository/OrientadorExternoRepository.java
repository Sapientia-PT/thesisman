package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Empresa;
import pt.ul.fc.css.example.demo.entities.OrientadorExterno;
import pt.ul.fc.css.example.demo.entities.Projeto;

import java.util.List;

public interface OrientadorExternoRepository extends JpaRepository<OrientadorExterno, Long> {

    @Query("SELECT e.orientadoresExternos FROM Empresa e WHERE e = :empresa")
    List<OrientadorExterno> findByEmpresa(@Param("empresa") Empresa empresa);

    @Query("SELECT p.orientadorExterno FROM Projeto p WHERE p = :projeto")
    OrientadorExterno findByProjeto(@Param("projeto") Projeto projeto);

}
