package pt.ul.fc.css.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ul.fc.css.example.demo.entities.Documento;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    Documento findByNrDocumento(long nrDocumento);

    List<Documento> findByNome(String nome);

    List<Documento> findByNota(float nota);
}
