package pt.ul.fc.css.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pt.ul.fc.css.example.demo.datatypes.EstadoAluno;
import pt.ul.fc.css.example.demo.datatypes.TipoDocumento;
import pt.ul.fc.css.example.demo.entities.Aluno;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.Documento;
import pt.ul.fc.css.example.demo.repositories.DefesaRepository;
import pt.ul.fc.css.example.demo.repositories.DocumentoRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DefesaDocumentoTests {

    @Autowired private DefesaRepository defesaRepository;
    @Autowired private DocumentoRepository documentoRepository;

    @BeforeEach
    public void setUp() {
        documentoRepository.save(new Documento(123, "Joao1", 10, TipoDocumento.PROPOSTA_DE_TESE));
        documentoRepository.save(new Documento(124, "Guilherme1", 10, TipoDocumento.PROPOSTA_DE_TESE));
        documentoRepository.save(new Documento(125, "Rafael1", 10, TipoDocumento.PROPOSTA_DE_TESE));

        defesaRepository.save(new Defesa(666, documentoRepository.findByNrDocumento(123)));
        defesaRepository.save(new Defesa(667, documentoRepository.findByNrDocumento(124)));
        defesaRepository.save(new Defesa(668, documentoRepository.findByNrDocumento(125)));
    }

    @AfterEach
    public void tearDown() {
        defesaRepository.deleteAll(); // Order is important because of cascade
        documentoRepository.deleteAll();
    }

    @Test
    public void getPropostas() {
        List<Defesa> defesas = defesaRepository.findByTipoDocumento(TipoDocumento.PROPOSTA_DE_TESE);
        assertEquals(3, defesas.size());
    }

    @Test
    public void getNonExistent(){
        Defesa defesa = defesaRepository.findByNrDefesa(0);
        assertNull(defesa);
    }

}
