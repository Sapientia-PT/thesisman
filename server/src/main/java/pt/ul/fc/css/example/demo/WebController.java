package pt.ul.fc.css.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pt.ul.fc.css.example.demo.business.services.EstatisticaService;
import pt.ul.fc.css.example.demo.business.services.Exceptions.ApplicationException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.business.services.TemaService;
import pt.ul.fc.css.example.demo.business.services.TeseService;
import pt.ul.fc.css.example.demo.business.services.UtilizadorService;
import pt.ul.fc.css.example.demo.entities.PropostaTese;

@Controller
@SessionAttributes("token")
public class WebController {

  @Autowired TemaService temaService;
  @Autowired TeseService teseService;
  @Autowired UtilizadorService utilizadorService;
  @Autowired EstatisticaService estatisticaService;

  @RequestMapping("/")
  public String getIndex() {
    return "redirect:/login";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/doLogin")
  public String doLogin(
      @RequestParam("nrConta") String nrConta, Model model, RedirectAttributes redirectAttributes) {
    try {
      String userToken = utilizadorService.getToken(Integer.parseInt(nrConta));
      if (userToken != null) {
        model.addAttribute("token", userToken);
        return "redirect:/menu";
      }
      redirectAttributes.addFlashAttribute("error", "User does not exist!");
      return "redirect:/login";
    } catch (NumberFormatException e) {
      redirectAttributes.addFlashAttribute("error", "Invalid user number!");
      return "redirect:/login";
    }
  }

  @RequestMapping("/registo")
  public String registro() {
    return "registo";
  }

  @PostMapping("/doRegisto")
  public String doRegistro(
      @RequestParam("username") String username,
      @RequestParam("nrConta") String nrConta,
      @RequestParam("nrEmpresa") String nrEmpresa,
      RedirectAttributes redirectAttributes) {
    try {
      utilizadorService.createOrientadorExterno(
          username, Integer.parseInt(nrConta), Long.parseLong(nrEmpresa));
      return "redirect:/login";
    } catch (NumberFormatException e) {
      redirectAttributes.addFlashAttribute("error", "The numbers must be numbers!");
      return "redirect:/registo";
    } catch (ApplicationException e) {
      redirectAttributes.addFlashAttribute("error", e.getMessage());
      return "redirect:/registo";
    }
  }

  @RequestMapping("/menu")
  public String menu() {
    return "menu";
  }

  // TODO Good for debugging
  @RequestMapping("/temas")
  public String temas(Model model) {
    model.addAttribute("temas", temaService.getTemas());
    return "temas";
  }

  @RequestMapping("/proporTema")
  public String proporTema(Model model) {
    if (utilizadorService.validateTokenForEmpresarioOrDocente((String) model.getAttribute("token")))
      return "proporTema";
    else return "redirect:/menu";
  }

  @PostMapping("/doProporTema")
  public String doProporTema(
      @RequestParam("titulo") String titulo,
      @RequestParam("descricao") String descricao,
      @RequestParam("remMensal") String remMensal,
      RedirectAttributes redirectAttributes) {
    try {
      temaService.submeterTema(titulo, descricao, Float.parseFloat(remMensal));
      return "redirect:/menu";
    } catch (NumberFormatException e) {
      redirectAttributes.addFlashAttribute("error", "Monthly pay must be a number!");
      return "redirect:/proporTema";
    } catch (ApplicationException e) {
      redirectAttributes.addFlashAttribute("error", e.getMessage());
      return "redirect:/proporTema";
    }
  }

  @RequestMapping("/atribuirTema")
  public String atribuirTema(Model model) {
    if (utilizadorService.validateTokenForAdministrador((String) model.getAttribute("token")))
      return "atribuirTema";
    else return "redirect:/menu";
  }

  @PostMapping("/doAtribuirTema")
  public String doAtribuirTema(
      @RequestParam("nrConta") String nrConta,
      @RequestParam("titulo") String titulo,
      RedirectAttributes redirectAttributes) {
    try {
      teseService.atribuirTemaALuno(
          temaService.getTema(titulo), utilizadorService.getAluno(Integer.parseInt(nrConta)));
      return "redirect:/menu";
    } catch (NumberFormatException e) {
      redirectAttributes.addFlashAttribute("error", "Aluno number must be a number!");
      return "redirect:/atribuirTema";
    } catch (ApplicationException e) {
      redirectAttributes.addFlashAttribute("error", e.getMessage());
      return "redirect:/atribuirTema";
    }
  }

  @RequestMapping("/listarPropostas")
  public String listarPropostas(Model model) {
    if (utilizadorService.validateTokenForEmpresarioOrDocente(
        (String) model.getAttribute("token"))) {
      model.addAttribute("propostas", teseService.getPropostas());
      return "listarPropostas";
    }
    return "redirect:/menu";
  }

  // TODO
  @RequestMapping("/marcarDefesa")
  public String marcarDefesa(@RequestParam("propostaId") Long propostaId, Model model) {
    try {
      PropostaTese proposta = teseService.getProposta(propostaId);
      model.addAttribute("salas", teseService.getSalas());
      model.addAttribute("proposta", proposta);
      return "marcarDefesa";
    } catch (NotFoundException e) {
      model.addAttribute("error", e.getMessage());
      return "redirect:/listarPropostas";
    }
  }

  // TODO
  @PostMapping("/doMarcarDefesa")
  public String doMarcarDefesa(
      @RequestParam("propostaId") Long propostaId,
      @RequestParam("duracao") int duracao,
      @RequestParam("sala") int nrSala,
      @RequestParam("data") String dataInicial,
      @RequestParam("hora") String dataFinal,
      @RequestParam("orientadorInterno") String orientadorInterno,
      @RequestParam("arguente") String arguente,
      @RequestParam("presidente") String presidente,
      Model model) {
    try {
      // Horario horario = teseService.createHorario(dataInicial, dataFinal);
      // Juri juri =
      //    teseService.createJuri(Integer.parseInt(nrArguente), Integer.parseInt(nrPresidente));
      // Defesa defesa = new Defesa(proposta, 60, horario, sala, 0);
      // teseService.marcarDefesa(horario, sala, juri, defesa);
      return "redirect:/menu";
    } catch (NumberFormatException e) {
      model.addAttribute("error", "The numbers must be numbers!");
      return "redirect:/marcarDefesa";
      // } catch (ApplicationException e) {
      //  model.addAttribute("error", e.getMessage());
      //  return "redirect:/marcarDefesa";
    }
  }

  // TODO
  @PostMapping("/doRegistoNota")
  public String doRegistoNota() {
    return "redirect:/menu";
  }

  @RequestMapping("/estatisticas")
  public String estatisticas(Model model) {
    model.addAttribute("alunosAprovados", estatisticaService.calcularNumeroAlunosAprovados());
    model.addAttribute("alunosReprovados", estatisticaService.calcularNumeroAlunosReprovados());
    return "estatisticas";
  }

  @RequestMapping("/logout")
  public String logout() {
    return "redirect:/login";
  }

  @RequestMapping("/init")
  public String initTest() {
    try {
      // create some initial data
      temaService.submeterTema("Republica das bananas", "Bananas!", 1000);
      temaService.submeterTema("Macacos", "Ooga Booga", 42);
      utilizadorService.createAluno("João", 58195, 20.0f);
      utilizadorService.createAluno("Guilherme", 58176, 10.0f);
      utilizadorService.createAluno("Rafael", 58236, 0.0f);
      utilizadorService.createDocente("Manuel", 10);
      utilizadorService.createDocente("João", 11);
      utilizadorService.createEmpresa("Empresa", 12345);
      utilizadorService.createAdministrador("Carlos", 1);
      // associate the tema with the aluno
      return "redirect:/login";
    } catch (ApplicationException e) {
      throw new RuntimeException(e);
    }
  }
}
