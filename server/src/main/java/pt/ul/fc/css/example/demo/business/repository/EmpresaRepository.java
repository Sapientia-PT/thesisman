package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.entities.Empresa;
import pt.ul.fc.css.example.demo.entities.OrientadorExterno;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByNrEmpresa(long nrEmpresa);
    Empresa findByNome(String nome);

    @Query("SELECT o.empresa FROM OrientadorExterno o WHERE o = :orientadorExterno")
    Empresa findByOrientadorExterno(@Param("orientadorExterno") OrientadorExterno orientadorExterno);
}
