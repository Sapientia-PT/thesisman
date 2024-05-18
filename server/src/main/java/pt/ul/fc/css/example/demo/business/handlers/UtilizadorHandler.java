package pt.ul.fc.css.example.demo.business.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.*;
import pt.ul.fc.css.example.demo.entities.*;

@Component
public class UtilizadorHandler {

  @Autowired private AlunoRepository alunoRepository;
  @Autowired private DocenteRepository docenteRepository;
  @Autowired private OrientadorExternoRepository orientadorExternoRepository;
  @Autowired private AdministradorRepository administradorRepository;
  @Autowired private PresidenteRepository presidenteRepository;

  public void createAluno(String nome, String token, int nrAluno, float media) {

    Aluno aluno = new Aluno();
    aluno.setNome(nome);
    aluno.setToken(token);
    aluno.setNrAluno(nrAluno);
    aluno.setMedia(media);

    alunoRepository.save(aluno);
  }

  public void createDocente(String nome, String token, int nrDocente) {

    Docente docente = new Docente();
    docente.setNome(nome);
    docente.setToken(token);
    docente.setNrDocente(nrDocente);

    docenteRepository.save(docente);
  }

  public void createOrientadorExterno(String nome, String token, Empresa empresa) {

    OrientadorExterno orientadorExterno = new OrientadorExterno();
    orientadorExterno.setNome(nome);
    orientadorExterno.setToken(token);
    orientadorExterno.setEmpresa(empresa);

    orientadorExternoRepository.save(orientadorExterno);
  }

  public void createAdministrador(String nome, String token) {
    Administrador administrador = new Administrador();
    administrador.setNome(nome);
    administrador.setToken(token);

    administradorRepository.save(administrador);
  }

  public void createPresidente(String nome, String token) {
    Presidente presidente = new Presidente();
    presidente.setNome(nome);
    presidente.setToken(token);

    presidenteRepository.save(presidente);
  }

  public boolean validateToken(String token) {
    return alunoRepository.findByToken(token) != null
        || docenteRepository.findByToken(token) != null
        || orientadorExternoRepository.findByToken(token) != null
        || administradorRepository.findByToken(token) != null
        || presidenteRepository.findByToken(token) != null;
  }
}
