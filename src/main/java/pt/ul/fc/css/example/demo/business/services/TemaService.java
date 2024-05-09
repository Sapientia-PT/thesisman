package pt.ul.fc.css.example.demo.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;
import pt.ul.fc.css.example.demo.business.handlers.TemaHandler;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NullTitleException;
import pt.ul.fc.css.example.demo.entities.Tema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private TemaHandler temaHandler;

    public TemaDTO createTema(String titulo, String descricao, float remunMensal) throws NullTitleException {
        Tema tema = temaHandler.createTema(titulo, descricao, remunMensal);
        return TemaService.dtofy(tema);
    }

    public Optional<TemaDTO> getTema(Long id) {
        return temaRepository.findById(id).map(TemaService::dtofy);
    }

    public List<TemaDTO> getTemas() {
        ArrayList<TemaDTO> temas = new ArrayList<>();
        for (Tema tema : temaRepository.findAll())
            temas.add(dtofy(tema));
        return temas;
    }

    public void deleteTema(Long id){
        temaRepository.deleteById(id);
    }

    public Optional<TemaDTO> replaceTema(Long id, TemaDTO newTemaData) {
        Optional<Tema> oldTema = temaRepository.findById(id);
        oldTema.ifPresent(tema -> {
            tema.setTitulo(newTemaData.getTitulo());
            tema.setDescricao(newTemaData.getDescricao());
            tema.setRemunMensal(newTemaData.getRemunMensal());
            temaRepository.save(tema);
        });
        return oldTema.map(TemaService::dtofy);
    }

    public Optional<TemaDTO> changeTema(Long id, TemaDTO newTemaData) {
        Optional<Tema> oldTema = temaRepository.findById(id);
        oldTema.ifPresent(tema -> {
            if (newTemaData.getTitulo() != null)
                tema.setTitulo(newTemaData.getTitulo());
            if (newTemaData.getDescricao() != null)
                tema.setDescricao(newTemaData.getDescricao());
            tema.setRemunMensal(newTemaData.getRemunMensal());
            temaRepository.save(tema);
        });
        return oldTema.map(TemaService::dtofy);
    }

    private static TemaDTO dtofy(Tema c) {
        TemaDTO temaDTO = new TemaDTO();
        temaDTO.setId(c.getId());
        temaDTO.setTitulo(c.getTitulo());
        temaDTO.setDescricao(c.getDescricao());
        temaDTO.setRemunMensal(c.getRemunMensal());
        return temaDTO;
    }
}
