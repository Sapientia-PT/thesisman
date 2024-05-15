package pt.ul.fc.css.example.demo.business.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.AlunoHandler;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.UserAlreadyExistsException;
import pt.ul.fc.css.example.demo.entities.Aluno;

@Service
public class UtilizadorService {

  @Autowired private AlunoRepository alunoRepository;

  @Autowired private AlunoHandler alunoHandler;

  @Autowired private TokenService tokenService;

  public String createAluno(String nome, int nrAluno, float media)
      throws UserAlreadyExistsException {
    Aluno aluno = alunoRepository.findByNrAluno(nrAluno);
    if (aluno != null)
      throw new UserAlreadyExistsException("Aluno with nrAluno " + nrAluno + " already exists");

    String generatedToken = tokenService.generateToken();
    alunoHandler.createAluno(nome, generatedToken, nrAluno, media);
    return generatedToken;
  }

  public AlunoDTO getAluno(int nrAluno) {
    return dtofy(alunoRepository.findByNrAluno(nrAluno));
  }

  public List<AlunoDTO> getAlunos() {
    return alunoRepository.findAll().stream().map(this::dtofy).collect(Collectors.toList());
  }

  private AlunoDTO dtofy(Aluno a) {
    AlunoDTO alunoDTO = new AlunoDTO();
    alunoDTO.setId(a.getId());
    alunoDTO.setNrAluno(a.getNrAluno());
    alunoDTO.setNome(a.getNome());
    alunoDTO.setMedia(a.getMedia());
    alunoDTO.setTese(a.getTese());
    alunoDTO.setTemasCandidatados(a.getTemasCandidatados());
    return alunoDTO;
  }
}
