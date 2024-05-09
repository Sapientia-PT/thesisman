package pt.ul.fc.css.example.demo.business.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;
import pt.ul.fc.css.example.demo.business.services.NullTitleException;
import pt.ul.fc.css.example.demo.entities.Tema;

@Component
public class TemaHandler {

    @Autowired
    private TemaRepository temaRepository;

    public Tema createTema(String titulo, String descricao, float remunMensal) throws NullTitleException {
        if(titulo.isEmpty())
            throw new NullTitleException("Titulo is a required field");

        Tema tema = new Tema();
        tema.setTitulo(titulo);
        tema.setDescricao(descricao);
        tema.setRemunMensal(remunMensal);
        return temaRepository.save(tema);
    }

}
