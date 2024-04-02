package pt.ul.fc.css.example.demo.repositories;

import pt.ul.fc.css.example.demo.entities.Docente;

public interface DocenteRepository {

    Docente findByNrDocente(long nrDocente);
    Docente findByNome(String nome);

}
