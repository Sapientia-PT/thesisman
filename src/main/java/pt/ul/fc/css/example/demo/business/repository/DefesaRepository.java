package pt.ul.fc.css.example.demo.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.ul.fc.css.example.demo.entities.Defesa;

public interface DefesaRepository extends JpaRepository<Defesa, Long> {

    Defesa findByNrDefesa(long nrDefesa);

}
