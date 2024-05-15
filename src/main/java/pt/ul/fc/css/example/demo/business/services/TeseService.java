package pt.ul.fc.css.example.demo.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.PropostaTeseHandler;
import pt.ul.fc.css.example.demo.business.handlers.TemaAlunoHandler;
import pt.ul.fc.css.example.demo.business.services.DTOs.AlunoDTO;
import pt.ul.fc.css.example.demo.business.services.DTOs.TemaDTO;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.entities.Tese;

@Service
public class TeseService {

  @Autowired private TemaAlunoHandler temaAlunoHandler;
  @Autowired private PropostaTeseHandler propostaTeseHandler;

  public void atribuirTemaALuno(TemaDTO temaDTO, AlunoDTO alunoDTO) throws NotFoundException {
    temaAlunoHandler.atribuirTemaAluno(temaDTO, alunoDTO);
  }

  public void submeterPropostaTese(Tese tese) throws NotFoundException {
    propostaTeseHandler.submeterPropostaTese(tese, 60);
  }

  public void submeterDocumentoFinal(Tese tese) throws NotFoundException {
    propostaTeseHandler.submeterPropostaTese(tese, 90);
  }
}
