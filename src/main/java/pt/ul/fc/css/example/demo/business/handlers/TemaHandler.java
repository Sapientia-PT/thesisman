package pt.ul.fc.css.example.demo.business.handlers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NullTitleException;
import pt.ul.fc.css.example.demo.entities.Tema;

@Component
public class TemaHandler {

  @Autowired private TemaRepository temaRepository;

  public TemaDTO createTema(String titulo, String descricao, float remunMensal)
      throws NullTitleException {
    if (titulo.isEmpty()) throw new NullTitleException("Titulo is a required field");

    Tema tema = new Tema();
    tema.setTitulo(titulo);
    tema.setDescricao(descricao);
    tema.setRemunMensal(remunMensal);

    return dtofy(temaRepository.save(tema));
  }

  public Optional<TemaDTO> getTema(Long id) {
    return temaRepository.findById(id).map(this::dtofy);
  }

  public List<TemaDTO> getTemas() {
    return temaRepository.findAll().stream().map(this::dtofy).collect(Collectors.toList());
  }

  public void deleteTema(Long id) {
    temaRepository.deleteById(id);
  }

  public Optional<TemaDTO> updateTema(Long id, TemaDTO newTemaData) {
    Optional<Tema> oldTema = temaRepository.findById(id);
    oldTema.ifPresent(
        tema -> {
          tema.setTitulo(newTemaData.getTitulo());
          tema.setDescricao(newTemaData.getDescricao());
          tema.setRemunMensal(newTemaData.getRemunMensal());
          temaRepository.save(tema);
        });
    return oldTema.map(this::dtofy);
  }

  public Optional<TemaDTO> changeTema(Long id, TemaDTO newTemaData) {
    Optional<Tema> oldTema = temaRepository.findById(id);
    oldTema.ifPresent(
        tema -> {
          if (newTemaData.getTitulo() != null) tema.setTitulo(newTemaData.getTitulo());
          if (newTemaData.getDescricao() != null) tema.setDescricao(newTemaData.getDescricao());
          tema.setRemunMensal(newTemaData.getRemunMensal());
          temaRepository.save(tema);
        });
    return oldTema.map(this::dtofy);
  }

  private TemaDTO dtofy(Tema c) {
    TemaDTO temaDTO = new TemaDTO();
    temaDTO.setId(c.getId());
    temaDTO.setTitulo(c.getTitulo());
    temaDTO.setDescricao(c.getDescricao());
    temaDTO.setRemunMensal(c.getRemunMensal());
    temaDTO.setAluno(c.getAluno());
    return temaDTO;
  }
}
