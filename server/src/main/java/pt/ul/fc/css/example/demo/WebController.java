package pt.ul.fc.css.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    return "redirect:/login";
  }

  @RequestMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @PostMapping("/doLogin")
  public String doLogin(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      Model model) {
    // mock login validation: accept any password, but validate if username exists in the database
    if (!username.isEmpty() && !password.isEmpty()) { // TODO Just for now
      // TODO add user details to the model if needed
      model.addAttribute("username", username);
      return "redirect:/temas"; // TODO change this to the main page
    }
    // If login fails, redirect back to the login page
    return "redirect:/login";
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
      // clear existing data
      temaService.clearTemas();
      utilizadorService.clearUtilizadores(); // TODO clear just alunos?
      // create some initial data
      TemaDTO tema1 = temaService.submeterTema("Republica das bananas", "Bananas!", 1000);
      TemaDTO tema2 = temaService.submeterTema("Macacos", "Ooga Booga", 42);
      String alunoToken = utilizadorService.createAluno("João", 58195, 20.0f);
      // associate the tema with the aluno
      temaService.candidatarTemaAluno(tema1, utilizadorService.getAluno(58195));
      return "init";
    } catch (ApplicationException e) {
      throw new RuntimeException(e);
    }
  }
}
