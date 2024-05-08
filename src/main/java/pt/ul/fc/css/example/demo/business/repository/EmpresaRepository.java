package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByNrEmpresa(long nrEmpresa);
    Empresa findByNome(String nome);
}
