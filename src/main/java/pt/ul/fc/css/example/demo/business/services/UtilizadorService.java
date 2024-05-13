package pt.ul.fc.css.example.demo.business.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.AlunoHandler;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.entities.Aluno;

@Service
public class UtilizadorService {

  @Autowired private AlunoRepository alunoRepository;

  @Autowired private AlunoHandler alunoHandler;

  public List<AlunoDTO> getAlunos() {
    return alunoHandler.getAlunos().stream().map(this::dtofy).collect(Collectors.toList());
  }

  public AlunoDTO createAluno(int nrAluno, String nome, float media) {
    return dtofy(alunoHandler.createAluno(nrAluno, nome, media));
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
