package pt.ul.fc.css.example.demo.business.handlers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.DefesaRepository;
import pt.ul.fc.css.example.demo.business.repository.PropostaTeseRepository;
import pt.ul.fc.css.example.demo.business.repository.TeseRepository;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.entities.Defesa;
import pt.ul.fc.css.example.demo.entities.PropostaTese;
import pt.ul.fc.css.example.demo.entities.Tese;

@Component
public class PropostaTeseHandler {

  @Autowired private PropostaTeseRepository propostaTeseRepository;
  @Autowired private TeseRepository teseRepository;
  @Autowired private DefesaRepository defesaRepository;

  public void submeterPropostaTese(Tese tese) throws NotFoundException {
    Optional<Tese> repoTese = teseRepository.findById(tese.getId());

    if (repoTese.isEmpty()) throw new NotFoundException("No tese found");

    Tese foundTese = repoTese.get();

    Defesa defesa = new Defesa();
    PropostaTese propostaTese = new PropostaTese();

    propostaTese.setTese(foundTese);
    propostaTese.setDefesa(defesa);
    defesa.setPropostaTese(propostaTese);
    foundTese.getPropostasTese().add(propostaTese);

    defesaRepository.save(defesa);
    propostaTeseRepository.save(propostaTese);
    teseRepository.save(foundTese);
  }
}
