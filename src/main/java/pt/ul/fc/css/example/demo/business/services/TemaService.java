package pt.ul.fc.css.example.demo.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.repository.AlunoRepository;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;
import pt.ul.fc.css.example.demo.business.handlers.TemaHandler;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.ApplicationException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NullTitleException;
import pt.ul.fc.css.example.demo.entities.Aluno;
import pt.ul.fc.css.example.demo.entities.Tema;

import java.util.List;
import java.util.Optional;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;
    @Autowired
    private TemaHandler temaHandler;

    @Autowired
    private AlunoRepository alunoRepository;

    public TemaDTO createTema(String titulo, String descricao, float remunMensal) throws NullTitleException {
        return temaHandler.createTema(titulo, descricao, remunMensal);
    }

    public List<TemaDTO> getTemas(){
        return temaHandler.getTemas();
    }

    public void candidatarTemaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO) throws ApplicationException {
        Optional<Aluno> optionalAluno = alunoRepository.findById(alunoDTO.getId());
        if (!optionalAluno.isPresent())
            throw new ApplicationException("Aluno not found");

        Optional<Tema> optionalTema = temaRepository.findById(temaDTO.getId());
        if (!optionalTema.isPresent()) {
            throw new ApplicationException("Tema not found");
        }

        Aluno aluno = optionalAluno.get();
        Tema tema = optionalTema.get();

        aluno.getTemasCandidatados().add(tema);
        tema.setAluno(aluno);

        alunoRepository.save(aluno);
        temaRepository.save(tema);
    }
}
