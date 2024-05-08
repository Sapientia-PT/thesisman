package pt.ul.fc.css.example.demo.business.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.repository.TemaRepository;

@Service
public class TemaHandler {

    @Autowired
    private TemaRepository temaRepository;



}
