package pt.ul.fc.css.example.demo.business.handlers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;
import pt.ul.fc.css.example.demo.business.repository.TeseRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.DuplicateTitleException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.MaximoTemasException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.entities.Aluno;
import pt.ul.fc.css.example.demo.entities.Tema;
import pt.ul.fc.css.example.demo.entities.Tese;

/**
 * This class reprents the handler for temas.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class TemaAlunoHandler {

  @Autowired private AlunoRepository alunoRepository;
  @Autowired private TemaRepository temaRepository;
  @Autowired private TeseRepository teseRepository;

  public void candidatarTemaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException, MaximoTemasException {
    Aluno aluno = alunoRepository.findByNrConta(alunoDTO.getNrConta());
    Tema tema = temaRepository.findByTitulo(temaDTO.getTitulo());

    if (aluno == null) throw new NotFoundException("Aluno not found!");
    if (tema == null) throw new NotFoundException("Tema not found!");

    List<Tema> temasAluno = aluno.getTemasCandidatados();
    if (temasAluno.size() == 5) throw new MaximoTemasException("Maximum number of temas reached!");

    temasAluno.add(tema);
    tema.setAluno(aluno);

    updateAlunoTema(aluno, tema);
  }

  public void cancelarCandidaturaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException {
    Aluno aluno = alunoRepository.findByNrConta(alunoDTO.getNrConta());
    Tema tema = temaRepository.findByTitulo(temaDTO.getTitulo());

    if (aluno == null) throw new NotFoundException("Aluno not found!");
    if (tema == null) throw new NotFoundException("Tema not found!");

    aluno.getTemasCandidatados().remove(tema);
    tema.setAluno(null);

    updateAlunoTema(aluno, tema);
  }

  public void atribuirTemaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException, DuplicateTitleException {
    // "Com essa atribuição começa a tese" -> Ou seja, por decisão nossa, criar e atribuir a tese ao
    // aluno neste método
    Aluno aluno = alunoRepository.findByNrConta(alunoDTO.getNrConta());
    Tema tema = temaRepository.findByTitulo(temaDTO.getTitulo());

    if (aluno == null) throw new NotFoundException("Aluno not found!");
    if (tema == null) throw new NotFoundException("Tema not found!");

    if (aluno.getTese() != null)
      throw new DuplicateTitleException("Aluno " + aluno.getNrConta() + " already has a tese!");

    // We do not associate with Docente (no time)
    Tese tese = new Tese();
    tese.setAluno(aluno);
    tese.setTema(tema);
    aluno.setTese(tese);
    teseRepository.save(tese);
    alunoRepository.save(aluno);
  }

  private void updateAlunoTema(Aluno aluno, Tema tema) {
    alunoRepository.save(aluno);
    temaRepository.save(tema);
  }
}
