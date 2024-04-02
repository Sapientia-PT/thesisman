package pt.ul.fc.css.example.demo.repositories;

import pt.ul.fc.css.example.demo.entities.Empresa;

import java.util.List;

public interface EmpresaRepository {
    Empresa findByNrEmpresa(long nrEmpresa);
    Empresa findByNome(String nome);
}
