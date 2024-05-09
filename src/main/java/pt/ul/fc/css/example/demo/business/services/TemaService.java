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
        Aluno aluno = findAlunoById(alunoDTO.getId());
        Tema tema = findTemaById(temaDTO.getId());

        aluno.getTemasCandidatados().add(tema);
        tema.setAluno(aluno);

        updateAlunoTema(aluno, tema);
    }

    public void cancelarCandidaturaAluno(TemaDTO temaDTO, AlunoDTO alunoDTO) throws ApplicationException {
        Aluno aluno = findAlunoById(alunoDTO.getId());
        Tema tema = findTemaById(temaDTO.getId());

        aluno.getTemasCandidatados().remove(tema);
        tema.setAluno(null);

        updateAlunoTema(aluno, tema);
    }

    private Aluno findAlunoById(Long id) throws ApplicationException {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (!optionalAluno.isPresent())
            throw new ApplicationException("Aluno not found");
        return optionalAluno.get();
    }


    private Tema findTemaById(Long id) throws ApplicationException {
        Optional<Tema> optionalTema = temaRepository.findById(id);
        if (!optionalTema.isPresent())
            throw new ApplicationException("Tema not found");
        return optionalTema.get();
    }

    private void updateAlunoTema(Aluno aluno, Tema tema){
        alunoRepository.save(aluno);
        temaRepository.save(tema);
    }

}
