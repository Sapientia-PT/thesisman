package pt.ul.fc.css.example.demo.business.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

  public List<PropostaTese> getPropostasWithoutHorario() {
    List<PropostaTese> allPropostas = propostaTeseRepository.findAll();
    return allPropostas.stream()
        .filter(
            proposta -> proposta.getDefesa() != null && proposta.getDefesa().getHorario() == null)
        .collect(Collectors.toList());
  }

  public List<Defesa> getDefesas() {
    List<Defesa> allDefesas = defesaRepository.findAll();
    return allDefesas.stream()
        .filter(
            defesa ->
                defesa.getHorario() != null) // it should be the defesas that have been concluded
        .collect(Collectors.toList()); // but for evaluation purposes we will consider all defesas
    // that have a horario
  }

  public PropostaTese getProposta(long id) throws NotFoundException {
    Optional<PropostaTese> proposta = propostaTeseRepository.findById(id);
    if (!proposta.isPresent()) throw new NotFoundException("Proposta not found!");
    return proposta.get();
  }

  public List<Sala> getSalas() {
    return salaRepository.findAll();
  }

  public Sala getSala(int nrSala) throws NotFoundException {
    return salaRepository.findByNrSala(nrSala); // it can be null (defesa remota)
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

  public Horario createHorario(String dataInicial, String dataFinal) {
    return propostaTeseHandler.createHorario(dataInicial, dataFinal);
  }

  public Juri createJuri(int nrArguente, int nrPresidente) {
    return propostaTeseHandler.createJuri(nrArguente, nrPresidente);
  }

  public void createSala(int nrSala) {
    propostaTeseHandler.createSala(nrSala);
  }

  public void updateNota(Long defesaId, int nota) {
    Defesa defesa =
        defesaRepository
            .findById(defesaId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid defesa Id: " + defesaId));
    defesa.setNota(nota);
    defesaRepository.save(defesa);
  }
}
