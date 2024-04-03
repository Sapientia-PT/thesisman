package pt.ul.fc.css.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.ul.fc.css.example.demo.entities.Mestrado;
import pt.ul.fc.css.example.demo.repositories.MestradoRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MestradoTests {
    @Autowired
    private MestradoRepository mestradoRepository;

    @BeforeEach
    void setUp(){
        mestradoRepository.save(new Mestrado(1, "Cibersecurity"));
        mestradoRepository.save(new Mestrado(2, "Dança do Tango"));
        mestradoRepository.save(new Mestrado(3, "Talhante"));
    }

    @AfterEach
    void cleanUp(){
        mestradoRepository.deleteAll();
    }

    @Test
    void isRepoNotEmpty(){ assertTrue(mestradoRepository.count() > 0); }

    @Test
    void findNonExisting(){ assertNull(mestradoRepository.findByIdMestrado(0)); }

    @Test
    void removeSomeone(){
        int nr_mestrado = 1;
        mestradoRepository.delete(mestradoRepository.findByIdMestrado(nr_mestrado));
        assertNull(mestradoRepository.findByIdMestrado(nr_mestrado));
    }
}
