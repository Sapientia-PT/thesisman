package pt.ul.fc.css.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.MaximoTemasException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.business.services.TemaService;
import pt.ul.fc.css.example.demo.business.services.TeseService;
import pt.ul.fc.css.example.demo.business.services.UtilizadorService;

/**
 * This is the main controller for the Rest Api. Handling all rest requests.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@RestController
@RequestMapping("/api")
public class RestAPI {

  @Autowired private UtilizadorService utilizadorService;
  @Autowired private TemaService temaService;
  @Autowired private TeseService teseService;

  /**
   * This method handles the get request to get a specific aluno.
   *
   * @param nrAluno The number of the aluno to retrieve.
   * @return AlunoDTO object.
   * @throws NotFoundException If the aluno does not exist.
   */
  @GetMapping("/aluno/{nrAluno}")
  public AlunoDTO getAluno(@PathVariable("nrAluno") int nrAluno) throws NotFoundException {
    return utilizadorService.getAluno(nrAluno);
  }

  /**
   * This method handles the get request to get temas.
   *
   * @return A list of TemaDTO objects.
   */
  @GetMapping("/temas")
  public List<TemaDTO> getTemas() {
    return temaService.getTemas();
  }

  /**
   * This method handles the post request to add a new tema.
   *
   * @param titulo The title of the tema.
   * @param nrConta The number of the conta.
   * @throws MaximoTemasException If the maximum number of temas is exceeded.
   * @throws NotFoundException If the conta does not exist.
   */
  @PostMapping("/tema")
  public void addTema(@RequestParam("titulo") String titulo, @RequestParam("nrConta") int nrConta)
      throws MaximoTemasException, NotFoundException {
    TemaDTO tema = new TemaDTO();
    tema.setTitulo(titulo);
    temaService.candidatarTemaAluno(tema, utilizadorService.getAluno(nrConta));
  }

  /**
   * This method handles the delete request to cancel a tema.
   *
   * @param titulo The title of the tema.
   * @param nrAluno The number of the aluno.
   * @throws MaximoTemasException If the maximum number of temas is exceeded.
   * @throws NotFoundException If the aluno does not exist.
   */
  @DeleteMapping("/tema")
  public void cancelarTema(
      @RequestParam("titulo") String titulo, @RequestParam("nrAluno") int nrAluno)
      throws MaximoTemasException, NotFoundException {
    TemaDTO tema = new TemaDTO();
    tema.setTitulo(titulo);
    temaService.cancelarCandidaturaAluno(tema, utilizadorService.getAluno(nrAluno));
  }

  @PostMapping("/submeter-proposta")
  public void submeterProposta(@RequestParam("nrAluno") int nrAluno) throws NotFoundException {
    teseService.submeterPropostaTese(nrAluno);
  }

  @PostMapping("/submeter-documento-final")
  public void submeterDocumentoFinal(@RequestParam("nrAluno") int nrAluno)
      throws NotFoundException {
    teseService.submeterDocumentoFinal(nrAluno);
  }
}
