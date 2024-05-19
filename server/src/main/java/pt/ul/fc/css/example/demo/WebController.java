package pt.ul.fc.css.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.ul.fc.css.example.demo.business.services.DTOs.EmpresaDTO;
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
  public String doLogin(@RequestParam("nrConta") String nrConta, Model model) {
    try {
      String userToken = utilizadorService.getToken(Integer.parseInt(nrConta));
      if (userToken != null) {
        model.addAttribute("token", userToken);
        return "redirect:/main";
      }
      // If the student doesn't exist
      model.addAttribute("error", "Student does not exist!");
      return "redirect:/login";
    } catch (NumberFormatException e) {
      model.addAttribute("error", "Invalid student number!");
      return "redirect:/login";
    }
  }

  @RequestMapping("/registo")
  public String registro(Model model) {
    return "registo";
  }

  @PostMapping("/doRegisto")
  public String doRegistro(
      @RequestParam("username") String username,
      @RequestParam("nrConta") String nrConta,
      @RequestParam("nrEmpresa") String nrEmpresa,
      Model model) {
    try {
      utilizadorService.createOrientadorExterno(
          username, Integer.parseInt(nrConta), Long.parseLong(nrEmpresa));
      return "redirect:/login";
      // TODO: Right now, the app will crash if the user already exists
    } catch (ApplicationException e) {
      model.addAttribute("error", "Error registrating user!");
      return "redirect:/registo";
    } catch (NumberFormatException e) {
      model.addAttribute("error", "Enterprise number must be a number!");
      return "redirect:/registo";
    }
  }

  @RequestMapping("/main")
  public String main(Model model) {
    return "main";
  }

  // TODO Maybe remove later
  @RequestMapping("/alunos")
  public String alunos(Model model) {
    model.addAttribute("alunos", utilizadorService.getAlunos());
    return "alunos";
  }

  // TODO Maybe remove later
  @RequestMapping("/temas")
  public String temas(Model model) {
    model.addAttribute("temas", temaService.getTemas());
    return "temas";
  }

  @RequestMapping("/proporTema")
  public String proporTema(Model model) {
    return "proporTema";
  }

  @PostMapping("/doProporTema")
  public String doProporTema(
      @RequestParam("titulo") String titulo,
      @RequestParam("descricao") String descricao,
      @RequestParam("maxAlunos") String maxAlunos,
      Model model) {
    try {
      temaService.submeterTema(titulo, descricao, Integer.parseInt(maxAlunos));
      return "redirect:/main";
    } catch (ApplicationException e) {
      model.addAttribute("error", "Error submitting theme!");
      return "redirect:/submeterTema";
    } catch (NumberFormatException e) {
      model.addAttribute("error", "Maximum number of students must be a number!");
      return "redirect:/submeterTema";
    }
  }

  @RequestMapping("/atribuirTema")
  public String atribuirTema(Model model) {
    return "atribuirTema";
  }

  @RequestMapping("/marcarDefesaProposta")
  public String avaliarTema(Model model) {
    return "marcarDefesaProposta";
  }

  @RequestMapping("/registarNota")
  public String registarNota(Model model) {
    return "registarNota";
  }

  @RequestMapping("/marcarDefesaFinal")
  public String marcarDefesaFinal(Model model) {
    return "marcarDefesaFinal";
  }

  @RequestMapping("/registarNotaFinal")
  public String registarNotaFinal(Model model) {
    return "registarNotaFinal";
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
      utilizadorService.clearUtilizadores();
      // create some initial data
      TemaDTO tema1 = temaService.submeterTema("Republica das bananas", "Bananas!", 1000);
      TemaDTO tema2 = temaService.submeterTema("Macacos", "Ooga Booga", 42);
      String alunoToken = utilizadorService.createAluno("João", 58195, 20.0f);
      EmpresaDTO empresa = utilizadorService.createEmpresa("Empresa", 12345);
      // associate the tema with the aluno
      temaService.candidatarTemaAluno(tema1, utilizadorService.getAluno(58195));
      return "init";
    } catch (ApplicationException e) {
      throw new RuntimeException(e);
    }
  }
}
