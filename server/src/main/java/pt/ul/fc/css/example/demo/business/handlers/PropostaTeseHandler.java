package pt.ul.fc.css.example.demo.business.handlers;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.business.repository.DefesaRepository;
import pt.ul.fc.css.example.demo.business.repository.DocenteRepository;
import pt.ul.fc.css.example.demo.business.repository.JuriRepository;
import pt.ul.fc.css.example.demo.business.repository.PropostaTeseRepository;
import pt.ul.fc.css.example.demo.business.repository.SalaRepository;
import pt.ul.fc.css.example.demo.business.repository.TeseRepository;
import pt.ul.fc.css.example.demo.business.services.Exceptions.HorarioInUseException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.entities.*;

/**
 * This class reprents the handler for proposta.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class PropostaTeseHandler {

  @Autowired private PropostaTeseRepository propostaTeseRepository;
  @Autowired private TeseRepository teseRepository;
  @Autowired private DefesaRepository defesaRepository;
  @Autowired private DocenteRepository docenteRepository;
  @Autowired private AlunoRepository alunoRepository;
  @Autowired private SalaRepository salaRepository;
  @Autowired private JuriRepository juriRepository;

  public void submeterPropostaTese(int nrConta, int duracaoMinutos) throws NotFoundException {
    Aluno aluno = alunoRepository.findByNrConta(nrConta);
    Tese tese = teseRepository.findByAluno(aluno);
    if (aluno == null) throw new NotFoundException("No aluno found");
    if (tese == null) throw new NotFoundException("No tese found");

    Defesa defesa = new Defesa();
    defesa.setDuracaoMinutos(duracaoMinutos);
    defesaRepository.save(defesa);

    PropostaTese propostaTese = new PropostaTese(tese, defesa);
    defesa.setPropostaTese(propostaTese);
    tese.getPropostasTese().add(propostaTese);

    propostaTeseRepository.save(propostaTese);
    defesaRepository.save(defesa);
    teseRepository.save(tese);
  }

  public void marcarDefesa(Horario horario, Sala sala, Juri juri, Defesa defesa)
      throws NotFoundException, HorarioInUseException {
    Optional<Defesa> repoDefesa = defesaRepository.findById(defesa.getId());

    if (repoDefesa.isEmpty()) throw new NotFoundException("No defesa found!");

    Defesa foundDefesa = repoDefesa.get();
    if (sala != null && isHorarioInUse(sala, horario))
      throw new HorarioInUseException("Horario is already in use!");
    foundDefesa.setSala(sala); // If null -> Remoto, else -> Presencial
    foundDefesa.setHorario(horario);
    foundDefesa.setJuri(juri);
    defesaRepository.save(foundDefesa);
  }

  private boolean isHorarioInUse(Sala sala, Horario horario) {
    return sala.getDefesas().stream().anyMatch(d -> d.getHorario().equals(horario));
  }

  public void createSala(int nrSala) {
    Sala sala = new Sala();
    sala.setNrSala(nrSala);
    salaRepository.save(sala);
  }

  public Horario createHorario(String dataInicial, String dataFinal) {
    Horario horario = new Horario();
    horario.setDataInicial(parseTime(dataInicial));
    horario.setDataFinal(parseTime(dataFinal));
    return horario;
  }

  private Time parseTime(String time) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
    LocalTime localTime = localDateTime.toLocalTime();
    return Time.valueOf(localTime);
  }

  public Juri createJuri(int nrArguente, int nrPresidente) {
    Juri juri = new Juri();
    juri.setArguente(docenteRepository.findByNrConta(nrArguente));
    juri.setPresidente(docenteRepository.findByNrConta(nrPresidente));
    juriRepository.save(juri);
    return juri;
  }
}
