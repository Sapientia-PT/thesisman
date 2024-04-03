package pt.ul.fc.css.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.ul.fc.css.example.demo.datatypes.EstadoAluno;
import pt.ul.fc.css.example.demo.datatypes.TipoTese;
import pt.ul.fc.css.example.demo.entities.Aluno;
import pt.ul.fc.css.example.demo.entities.Tema;
import pt.ul.fc.css.example.demo.entities.Tese;
import pt.ul.fc.css.example.demo.repositories.AlunoRepository;
import pt.ul.fc.css.example.demo.repositories.TemaRepository;
import pt.ul.fc.css.example.demo.repositories.TeseRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlunoTests {

    @Autowired private AlunoRepository alunoRepo;
    @Autowired private TeseRepository teseRepo;
    @Autowired private TemaRepository temaRepo;

    @BeforeEach
    void setUp(){
        Tema tema1 = temaRepo.save(new Tema("Tema1", "Primeiro tema", 1));
        Tema tema2 = temaRepo.save(new Tema("Tema2", "Segundo tema", 10));
        Tema tema3 = temaRepo.save(new Tema("Tema3", "Terceiro tema", 100));

        Tese tese1 = teseRepo.save(new Tese(1, tema1, 20, List.of(), TipoTese.DISSERTACAO));
        Tese tese2 = teseRepo.save(new Tese(1, tema2, 20, List.of(), TipoTese.DISSERTACAO));
        Tese tese3 = teseRepo.save(new Tese(1, tema3, 20, List.of(), TipoTese.DISSERTACAO));

        alunoRepo.save(new Aluno(58195, "João", 11, EstadoAluno.PENDENTE, tese1));
        alunoRepo.save(new Aluno(58176, "Guilherme", 7, EstadoAluno.REPROVADO, tese2));
        alunoRepo.save(new Aluno(58236, "Rafael", 20, EstadoAluno.APROVADO, tese3));
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
    void addDouble(){
        long initialSize = alunoRepo.count();
        alunoRepo.save(alunoRepo.findByNome("João").get(0));
        assertEquals(initialSize, alunoRepo.count());
    }

    @Test
    void findStudyGods(){
        assertEquals(1, alunoRepo.findByMedia(20).size());
    }
}
