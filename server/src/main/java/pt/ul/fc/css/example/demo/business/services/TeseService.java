package pt.ul.fc.css.example.demo.business.services;

import java.sql.Time;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.PropostaTeseHandler;
import pt.ul.fc.css.example.demo.business.handlers.TemaAlunoHandler;
import pt.ul.fc.css.example.demo.business.repository.DefesaRepository;
import pt.ul.fc.css.example.demo.business.repository.PropostaTeseRepository;
import pt.ul.fc.css.example.demo.business.repository.SalaRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.DuplicateTitleException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.HorarioInUseException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.Horario;
import pt.ul.fc.css.example.demo.entities.Juri;
import pt.ul.fc.css.example.demo.entities.PropostaTese;
import pt.ul.fc.css.example.demo.entities.Sala;

@Service
public class TeseService {

  @Autowired private TemaAlunoHandler temaAlunoHandler;
  @Autowired private PropostaTeseHandler propostaTeseHandler;

  @Autowired private SalaRepository salaRepository;
  @Autowired private DefesaRepository defesaRepository;
  @Autowired private PropostaTeseRepository propostaTeseRepository;

  public void atribuirTemaALuno(TemaDTO temaDTO, AlunoDTO alunoDTO)
      throws NotFoundException, DuplicateTitleException {
    temaAlunoHandler.atribuirTemaAluno(temaDTO, alunoDTO);
  }

  public void submeterPropostaTese(int nrConta) throws NotFoundException {
    propostaTeseHandler.submeterPropostaTese(nrConta, 60);
  }

  public void submeterDocumentoFinal(int nrConta) throws NotFoundException {
    propostaTeseHandler.submeterPropostaTese(nrConta, 90);
  }

  public List<PropostaTese> getPropostas() {
    return propostaTeseRepository.findAll();
  }

  public PropostaTese getProposta(long id) throws NotFoundException {
    Optional<PropostaTese> proposta = propostaTeseRepository.findById(id);
    if (!proposta.isPresent()) throw new NotFoundException("Proposta não encontrada");
    return proposta.get();
  }

  public List<Sala> getSalas() {
    return salaRepository.findAll();
  }

  public void marcarDefesa(Horario horario, Sala sala, Juri juri, Defesa defesa)
      throws NotFoundException, HorarioInUseException {
    propostaTeseHandler.marcarDefesa(horario, sala, juri, defesa);
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

  public Horario createHorario(Time dataInicial, Time dataFinal) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createHorario'");
  }

  public Juri createJuri(int int1, int int2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createJuri'");
  }

  public void createSala(int nrSala) {
    propostaTeseHandler.createSala(nrSala);
  }
}
