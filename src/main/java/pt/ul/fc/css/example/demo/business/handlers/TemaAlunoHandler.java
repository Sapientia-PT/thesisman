package pt.ul.fc.css.example.demo.business.handlers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.MaximoTemasException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.entities.Aluno;
import pt.ul.fc.css.example.demo.entities.Tema;

@Component
public class TemaAlunoHandler {

  @Autowired private AlunoRepository alunoRepository;
  @Autowired private TemaRepository temaRepository;

  public void candidatarTemaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException, MaximoTemasException {
    Optional<Aluno> aluno = alunoRepository.findById(alunoDTO.getId());
    Optional<Tema> tema = temaRepository.findById(temaDTO.getId());

    if (aluno.isEmpty()) throw new NotFoundException("Aluno not found");
    if (tema.isEmpty()) throw new NotFoundException("Tema not found");

    List<Tema> temasAluno = aluno.get().getTemasCandidatados();
    if (temasAluno.size() == 5) throw new MaximoTemasException("Aluno atingiu maximo temas");

    temasAluno.add(tema.get());
    tema.get().setAluno(aluno.get());

    updateAlunoTema(aluno.get(), tema.get());
  }

  public void cancelarCandidaturaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException {
    Optional<Aluno> aluno = alunoRepository.findById(alunoDTO.getId());
    Optional<Tema> tema = temaRepository.findById(temaDTO.getId());

    if (aluno.isEmpty()) throw new NotFoundException("Aluno not found");
    if (tema.isEmpty()) throw new NotFoundException("Tema not found");

    aluno.get().getTemasCandidatados().remove(tema.get());
    tema.get().setAluno(null);

    updateAlunoTema(aluno.get(), tema.get());
  }

  private void updateAlunoTema(Aluno aluno, Tema tema) {
    alunoRepository.save(aluno);
    temaRepository.save(tema);
  }
}
