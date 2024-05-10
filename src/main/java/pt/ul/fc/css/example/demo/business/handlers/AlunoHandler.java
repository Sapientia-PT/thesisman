package pt.ul.fc.css.example.demo.business.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.entities.Aluno;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlunoHandler {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDTO createAluno(int nrAluno, String nome, float media){

        Aluno aluno = new Aluno();
        aluno.setNrAluno(nrAluno);
        aluno.setNome(nome);
        aluno.setMedia(media);

        return dtofy(alunoRepository.save(aluno));
    }

    public List<AlunoDTO> getAlunos() {
        ArrayList<AlunoDTO> alunos = new ArrayList<>();
        for (Aluno aluno : alunoRepository.findAll())
            alunos.add(dtofy(aluno));
        return alunos;
    }

    private AlunoDTO dtofy(Aluno a) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(a.getId());
        alunoDTO.setNrAluno(a.getNrAluno());
        alunoDTO.setNome(a.getNome());
        alunoDTO.setMedia(a.getMedia());
        alunoDTO.setTese(a.getTese());
        alunoDTO.setTemasEscolhidos(a.getTemasCandidatados());
        return alunoDTO;
    }
}
