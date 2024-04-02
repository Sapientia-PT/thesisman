package pt.ul.fc.css.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.ul.fc.css.example.demo.datatypes.EstadoAluno;
import pt.ul.fc.css.example.demo.entities.Aluno;
import pt.ul.fc.css.example.demo.repositories.AlunoRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlunoTests {

    @Autowired private AlunoRepository alunoRepo;

    @BeforeEach
    void setUp(){
        alunoRepo.save(new Aluno(58195, "João", 11, EstadoAluno.PENDENTE));
        alunoRepo.save(new Aluno(58176, "Guilherme", 7, EstadoAluno.REPROVADO));
        alunoRepo.save(new Aluno(58236, "Rafael", 20, EstadoAluno.APROVADO));
    }

    @AfterEach
    void cleanUp(){
        alunoRepo.deleteAll();
    }

    @Test
    void isRepoNotEmpty(){ assertTrue(alunoRepo.count() > 0); }

    @Test
    void isSize3(){ assertEquals(3, alunoRepo.count()); }

    @Test
    void removeReprovados(){
        long initialLength = alunoRepo.count();
        List<Aluno> reprovados = alunoRepo.findByEstadoAluno(EstadoAluno.REPROVADO);
        alunoRepo.deleteAll(reprovados);

        assertTrue(alunoRepo.findByEstadoAluno(EstadoAluno.REPROVADO).isEmpty());
        assertEquals(initialLength - reprovados.size(), alunoRepo.count());
    }

    @Test
    void findNonExisting(){ assertNull(alunoRepo.findByNrAluno(0)); }

    @Test
    void removeSomeone(){
        int nr_aluno = 58195;
        alunoRepo.delete(alunoRepo.findByNrAluno(nr_aluno));
        assertNull(alunoRepo.findByNrAluno(nr_aluno));
    }

    @Test
    void addSomeone(){
        Aluno a = alunoRepo.save(new Aluno(12345, "Alcides", 20, EstadoAluno.PENDENTE));
        assertNotNull(alunoRepo.findByNrAluno(12345));
    }

    @Test
    void addDouble(){
        long initialSize = alunoRepo.count();
        alunoRepo.save(alunoRepo.findByNome("João").get(0));
        assertEquals(initialSize, alunoRepo.count());
    }

    @Test
    void addSameNrAluno(){
        int id = alunoRepo.findByNome("João").get(0).getNrAluno();

        assertThrows(Exception.class, () -> {
            alunoRepo.save(new Aluno(id, "Alcides", 20, EstadoAluno.PENDENTE));
        });
    }

    @Test
    void findStudyGods(){
        assertEquals(1, alunoRepo.findByMedia(20).size());
    }
}
