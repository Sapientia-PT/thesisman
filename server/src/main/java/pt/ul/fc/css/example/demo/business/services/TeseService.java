package pt.ul.fc.css.example.demo.business.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.PropostaTeseHandler;
import pt.ul.fc.css.example.demo.business.handlers.TemaAlunoHandler;
import pt.ul.fc.css.example.demo.business.repository.DefesaRepository;
import pt.ul.fc.css.example.demo.business.repository.PropostaTeseRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.DuplicateTitleException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.Horario;
import pt.ul.fc.css.example.demo.entities.PropostaTese;
import pt.ul.fc.css.example.demo.entities.Sala;

@Service
public class TeseService {

  @Autowired private TemaAlunoHandler temaAlunoHandler;
  @Autowired private PropostaTeseHandler propostaTeseHandler;

  @Autowired private DefesaRepository defesaRepository;
  @Autowired private PropostaTeseRepository propostaTeseRepository;

  public void atribuirTemaALuno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException, DuplicateTitleException {
    temaAlunoHandler.atribuirTemaAluno(temaDTO, alunoDTO);
  }

  public void submeterPropostaTese(int nrAluno) throws NotFoundException {
    propostaTeseHandler.submeterPropostaTese(nrAluno, 60);
  }

  public void submeterDocumentoFinal(int nrAluno) throws NotFoundException {
    propostaTeseHandler.submeterPropostaTese(nrAluno, 90);
  }

  public List<PropostaTese> getPropostas() {
    return propostaTeseRepository.findAll();
  }

  public void marcarDefesa(Horario hora, Sala sala, Defesa defesa) throws NotFoundException {
    propostaTeseHandler.marcarDefesa(hora, sala, defesa);
  }

  public void registaNotaDefesa(int nota, Defesa defesa) {
    defesaRepository
        .findById(defesa.getId())
        .ifPresent(
            d -> {
              d.setNota(nota);
              defesaRepository.save(d);
            });
  }
}
