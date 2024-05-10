package pt.ul.fc.css.example.demo.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.AlunoHandler;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;

import java.util.List;

@Service
public class UtilizadorService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private AlunoHandler alunoHandler;

    public List<AlunoDTO> getAlunos(){
        return alunoHandler.getAlunos();
    }

    public AlunoDTO createAluno(int nrAluno, String nome, float media){
        return alunoHandler.createAluno(nrAluno, nome, media);
    }

}
