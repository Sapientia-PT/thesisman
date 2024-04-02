package pt.ul.fc.css.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Empresa;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByNrEmpresa(long nrEmpresa);
    Empresa findByNome(String nome);
}
