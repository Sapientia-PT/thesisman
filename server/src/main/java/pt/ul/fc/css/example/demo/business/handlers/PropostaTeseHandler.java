package pt.ul.fc.css.example.demo.business.handlers;

import java.sql.Time;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.DefesaRepository;
import pt.ul.fc.css.example.demo.business.repository.PropostaTeseRepository;
import pt.ul.fc.css.example.demo.business.repository.TeseRepository;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.PropostaTese;
import pt.ul.fc.css.example.demo.entities.Sala;
import pt.ul.fc.css.example.demo.entities.Tese;

@Component
public class PropostaTeseHandler {

  @Autowired private PropostaTeseRepository propostaTeseRepository;
  @Autowired private TeseRepository teseRepository;
  @Autowired private DefesaRepository defesaRepository;

  public void submeterPropostaTese(Tese tese, int duracaoMinutos) throws NotFoundException {
    Optional<Tese> repoTese = teseRepository.findById(tese.getId());

    if (repoTese.isEmpty()) throw new NotFoundException("No tese found");

    Tese foundTese = repoTese.get();

    Defesa defesa = new Defesa();
    defesa.setDuracaoMinutos(duracaoMinutos);
    PropostaTese propostaTese = new PropostaTese();

    propostaTese.setTese(foundTese);
    propostaTese.setDefesa(defesa);
    defesa.setPropostaTese(propostaTese);
    foundTese.getPropostasTese().add(propostaTese);

    defesaRepository.save(defesa);
    propostaTeseRepository.save(propostaTese);
    teseRepository.save(foundTese);
  }

  // Defesa Presencial
  public void marcarDefesa(Time hora, Sala sala, Defesa defesa) throws NotFoundException {
    Optional<Defesa> repoDefesa = defesaRepository.findById(defesa.getId());

    if (repoDefesa.isEmpty()) throw new NotFoundException("No defesa found");

    // TODO: Fazer verificaco dos horarios da sala
    Defesa foundDefesa = repoDefesa.get();
    defesa.setSala(sala);
    defesa.setHora(hora);
    defesaRepository.save(foundDefesa);
  }

  // Defesa Remota
  public void marcarDefesa(Time hora, Defesa defesa) throws NotFoundException {
    Optional<Defesa> repoDefesa = defesaRepository.findById(defesa.getId());

    if (repoDefesa.isEmpty()) throw new NotFoundException("No defesa found");

    Defesa foundDefesa = repoDefesa.get();
    defesa.setHora(hora);
    defesaRepository.save(foundDefesa);
  }
}
