package pt.ul.fc.css.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.EstatisticaService;
import pt.ul.fc.css.example.demo.business.services.Exceptions.ApplicationException;
import pt.ul.fc.css.example.demo.business.services.TemaService;
import pt.ul.fc.css.example.demo.business.services.UtilizadorService;

@Controller
public class WebController {

  @Autowired TemaService temaService;
  @Autowired UtilizadorService utilizadorService;
  @Autowired EstatisticaService estatisticaService;

  @RequestMapping("/")
  public String getIndex(Model model) {
    return "redirect:/temas";
  }

  @RequestMapping("/alunos")
  public String alunos(Model model) {
    model.addAttribute("alunos", utilizadorService.getAlunos());
    return "alunos";
  }

  @RequestMapping("/temas")
  public String temas(Model model) {
    model.addAttribute("temas", temaService.getTemas());
    return "temas";
  }

  @RequestMapping("/estatisticas")
  public String estatisticas(Model model) {
    model.addAttribute("alunosAprovados", estatisticaService.calcularNumeroAlunosAprovados());
    model.addAttribute("alunosReprovados", estatisticaService.calcularNumeroAlunosReprovados());
    return "estatisticas";
  }

  @RequestMapping("/init")
  public String initTest(Model model) {
    try {
      // TODO: implement clear data
      // create some data
      TemaDTO tema1 = temaService.submeterTema("Republica das bananas", "Bananas!", 1000);
      temaService.submeterTema("Macacos", "Ooga Booga", 42);
      String alunoToken = utilizadorService.createAluno("João", 58195, 20.0f);
      temaService.candidatarTemaAluno(tema1, utilizadorService.getAluno(58195));
      return "init";
    } catch (ApplicationException e) {
      throw new RuntimeException(e);
    }
  }
}
