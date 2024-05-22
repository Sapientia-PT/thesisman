package pt.ul.fc.css.example.demo.business.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;
import pt.ul.fc.css.example.demo.business.services.Exceptions.DuplicateTitleException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NullTitleException;
import pt.ul.fc.css.example.demo.entities.Tema;

/**
 * This class reprents the handler for submition of temas.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class SubmeterTemaHandler {

  @Autowired private TemaRepository temaRepository;

  public Tema createTema(String titulo, String descricao, float remunMensal)
      throws NullTitleException, DuplicateTitleException {
    if (titulo.isEmpty()) throw new NullTitleException("Titulo is a required field");

    Tema tema = new Tema();
    tema.setTitulo(titulo);
    tema.setDescricao(descricao);
    tema.setRemunMensal(remunMensal);

    try {
      return temaRepository.save(tema);
    } catch (DataIntegrityViolationException e) {
      throw new DuplicateTitleException("A Tema with this title already exists.");
    }
  }
}
