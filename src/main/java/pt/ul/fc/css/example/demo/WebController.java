package pt.ul.fc.css.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.ul.fc.css.example.demo.business.services.NullTitleException;
import pt.ul.fc.css.example.demo.business.services.TemaService;

@Controller
public class WebController {

    @Autowired
    TemaService temaService;

    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("temas", temaService.getTemas());
        return "index";
    }


    @RequestMapping("/init")
    public String initTest(Model model) {
        try{
            temaService.createTema("Republica das bananas", "Bananas!", 1000);
            temaService.createTema("Macacos", "Ooga Booga", 42);
            return "init";
        } catch (NullTitleException e) {
            throw new RuntimeException(e);
        }
    }
}
