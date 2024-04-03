package pt.ul.fc.css.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.ul.fc.css.example.demo.datatypes.TipoDocumento;
import pt.ul.fc.css.example.demo.entities.Documento;
import pt.ul.fc.css.example.demo.entities.Tema;
import pt.ul.fc.css.example.demo.entities.Tese;
import pt.ul.fc.css.example.demo.repositories.TemaRepository;
import pt.ul.fc.css.example.demo.repositories.TeseRepository;

import java.util.List;

@SpringBootTest
public class TeseTemaTests {

     @Autowired private TeseRepository teseRepository;
     @Autowired private TemaRepository temaRepository;

    @BeforeEach
    public void setUp() {
        Tema tema1 = temaRepository.save(new Tema("Patos na cibersegurança", "Dançar", 100));
        Tema tema2 = temaRepository.save(new Tema("Dança do Tango aplicada", "Dançar", 200));
        Tema tema3 = temaRepository.save(new Tema("Geologia astróloga", "Dançar", 300));

        // Create teses below

    }

    @AfterEach
    public void tearDown() {
        teseRepository.deleteAll(); // Order is important because of cascade
        temaRepository.deleteAll();
    }
}
