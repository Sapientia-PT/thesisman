package pt.ul.fc.css.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.ul.fc.css.example.demo.datatypes.TipoDocumento;
import pt.ul.fc.css.example.demo.entities.Defesa;

public interface DefesaRepository extends JpaRepository<Defesa, Long> {

    Defesa findByNrDefesa(long nrDefesa);


    @Query("SELECT d FROM Defesa d WHERE d.documento.tipoDocumento = :tipoDocumento")
    List<Defesa> findByTipoDocumento(@Param("tipoDocumento") TipoDocumento tipoDocumento);

}
