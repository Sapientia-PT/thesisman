package pt.ul.fc.css.example.demo.business.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.SubmeterTemaHandler;
import pt.ul.fc.css.example.demo.business.handlers.TemaAlunoHandler;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.DuplicateTitleException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.MaximoTemasException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NullTitleException;
import pt.ul.fc.css.example.demo.entities.Tema;

/**
 * This class reprents the Tema Service. Handles the logic for calling all the handlers related to
 * Tema.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Service
public class TemaService {

  @Autowired private TemaRepository temaRepository;

  @Autowired private SubmeterTemaHandler submeterTemaHandler;
  @Autowired private TemaAlunoHandler temaAlunoHandler;

  public TemaDTO getTema(String titulo) throws NotFoundException {
    Tema tema = temaRepository.findByTitulo(titulo);
    if (tema == null) throw new NotFoundException("Tema not found!");
    return dtofy(tema);
  }

  public List<TemaDTO> getTemas() {
    return temaRepository.findAll().stream().map(this::dtofy).collect(Collectors.toList());
  }

  public TemaDTO submeterTema(String titulo, String descricao, float remunMensal)
      throws NullTitleException, DuplicateTitleException {
    return dtofy(submeterTemaHandler.createTema(titulo, descricao, remunMensal));
  }

  public void candidatarTemaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException, MaximoTemasException {
    temaAlunoHandler.candidatarTemaAluno(temaDTO, alunoDTO);
  }

  public void cancelarCandidaturaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException {
    temaAlunoHandler.cancelarCandidaturaAluno(temaDTO, alunoDTO);
  }

  public void clearTemas() {
    temaRepository.deleteAll();
  }

  private TemaDTO dtofy(Tema c) {
    AlunoDTO alunoDTO = null;
    if (c.getAluno() != null) {
      alunoDTO = new AlunoDTO();
      alunoDTO.setNrConta(c.getAluno().getNrConta());
      alunoDTO.setNome(c.getAluno().getNome());
      alunoDTO.setMedia(c.getAluno().getMedia());
    }

    TemaDTO temaDTO = new TemaDTO();
    temaDTO.setId(c.getId());
    temaDTO.setTitulo(c.getTitulo());
    temaDTO.setDescricao(c.getDescricao());
    temaDTO.setRemunMensal(c.getRemunMensal());
    temaDTO.setAluno(alunoDTO);
    return temaDTO;
  }
}
