package pt.ul.fc.css.example.demo.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.TemaAlunoHandler;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;

@Service
public class TeseService {

  @Autowired private TemaAlunoHandler temaAlunoHandler;

  public void atribuirTemaALuno(TemaDTO temaDTO, AlunoDTO alunoDTO) throws NotFoundException {
    temaAlunoHandler.atribuirTemaAluno(temaDTO, alunoDTO);
  }
}
