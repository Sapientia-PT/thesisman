package pt.ul.fc.css.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.ul.fc.css.example.demo.entities.Empresa;
import pt.ul.fc.css.example.demo.repositories.EmpresaRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmpresaTests {

    @Autowired
    private EmpresaRepository empresaRepository;

    @BeforeEach
    void setUp(){
        empresaRepository.save(new Empresa(1, "Microsoft"));
        empresaRepository.save(new Empresa(2, "Google"));
        empresaRepository.save(new Empresa(3, "Meta"));
    }

    @AfterEach
    void cleanUp(){
        empresaRepository.deleteAll();
    }

    @Test
    void isRepoNotEmpty(){ assertTrue(empresaRepository.count() > 0); }

    @Test
    void findNonExisting(){ assertNull(empresaRepository.findByNrEmpresa(0)); }

    @Test
    void removeSomeone(){
        int nr_empresa = 1;
        empresaRepository.delete(empresaRepository.findByNrEmpresa(nr_empresa));
        assertNull(empresaRepository.findByNrEmpresa(nr_empresa));
    }
}
