package pt.ul.fc.css.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.ul.fc.css.example.demo.entities.Horario;
import pt.ul.fc.css.example.demo.entities.Sala;
import pt.ul.fc.css.example.demo.repositories.HorarioRepository;
import pt.ul.fc.css.example.demo.repositories.SalaRepository;

@SpringBootTest
public class HorarioSalaTests {

  @Autowired private HorarioRepository horarioRepo;
  @Autowired private SalaRepository salaRepo;

  @BeforeEach
  void setUp() {
    horarioRepo.save(new Horario(Time.valueOf("08:00:00"), Time.valueOf("10:00:00"), null));

    Sala s1 = salaRepo.save(new Sala(1, null));
    horarioRepo.save(new Horario(Time.valueOf("10:00:00"), Time.valueOf("12:00:00"), s1));
    s1.setHorarios(List.of(horarioRepo.findBySala(s1).get(0)));
  }

  @AfterEach
  void cleanUp() {
    horarioRepo.deleteAll();
    salaRepo.deleteAll();
  }

  @Test
  void areRepoNotEmpty() {
    assertTrue(horarioRepo.count() > 0);
    assertTrue(salaRepo.count() > 0);
  }

  @Test
  void areCorrectSize() {
    assertEquals(2, horarioRepo.count());
    assertEquals(1, salaRepo.count());
  }

  @Test
  void findNonExisting() {
    assertTrue(horarioRepo.findBeforeHora(Time.valueOf("07:00:00")).isEmpty());
    assertTrue(horarioRepo.findAfterHora(Time.valueOf("17:00:00")).isEmpty());
    salaRepo.save(new Sala(2, null));
    assertTrue(horarioRepo.findBySala(salaRepo.findByNrSala(2)).isEmpty());
    assertNull(salaRepo.findByNrSala(3));
  }

  @Test
  void removeBlock() {
    long initialLength = horarioRepo.count();
    horarioRepo.delete(horarioRepo.findBeforeHora(Time.valueOf("08:00:01")).get(0));

    assertTrue(horarioRepo.findBeforeHora(Time.valueOf("09:00:00")).isEmpty());
    assertEquals(initialLength - 1, horarioRepo.count());
  }
}
