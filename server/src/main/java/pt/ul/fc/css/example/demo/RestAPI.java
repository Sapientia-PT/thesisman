package pt.ul.fc.css.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.UtilizadorService;

@RestController
@RequestMapping("/api")
public class RestAPI {

    @Autowired
    private UtilizadorService utilizadorService;
    @GetMapping("/aluno/{nrAluno}")
    public AlunoDTO getAluno(@PathVariable("nrAluno") int nrAluno) {
        return utilizadorService.getAluno(nrAluno);
    }

}
