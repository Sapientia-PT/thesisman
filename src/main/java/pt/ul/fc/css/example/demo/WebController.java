package pt.ul.fc.css.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.ApplicationException;
import pt.ul.fc.css.example.demo.business.services.TemaService;
import pt.ul.fc.css.example.demo.business.services.UtilizadorService;

@Controller
public class WebController {

    @Autowired
    TemaService temaService;

    @Autowired
    UtilizadorService utilizadorService;

    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("temas", temaService.getTemas());
        return "index";
    }


    @RequestMapping("/init")
    public String initTest(Model model) {
        try{
            TemaDTO tema1 = temaService.createTema("Republica das bananas", "Bananas!", 1000);
            temaService.createTema("Macacos", "Ooga Booga", 42);
            AlunoDTO aluno1 = utilizadorService.createAluno(58195, "João", 20.0f);
            temaService.candidatarTemaAluno(tema1, aluno1);
            return "init";
        } catch (ApplicationException e){
            throw new RuntimeException(e);
        }
    }
}
