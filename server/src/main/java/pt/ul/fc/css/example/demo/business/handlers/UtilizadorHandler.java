package pt.ul.fc.css.example.demo.business.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.ul.fc.css.example.demo.business.repository.*;
import pt.ul.fc.css.example.demo.business.services.Exceptions.UserAlreadyExistsException;
import pt.ul.fc.css.example.demo.entities.*;

@Component
public class UtilizadorHandler {

  @Autowired private AlunoRepository alunoRepository;
  @Autowired private DocenteRepository docenteRepository;
  @Autowired private EmpresaRepository empresaRepository;
  @Autowired private OrientadorExternoRepository orientadorExternoRepository;
  @Autowired private AdministradorRepository administradorRepository;
  @Autowired private PresidenteRepository presidenteRepository;

  public void createAluno(String nome, String token, int nrAluno, float media) {

    Aluno aluno = new Aluno();
    aluno.setNome(nome);
    aluno.setToken(token);
    aluno.setNrConta(nrAluno);
    aluno.setMedia(media);

    alunoRepository.save(aluno);
  }

  public void createDocente(String nome, String token, int nrDocente) {

    Docente docente = new Docente();
    docente.setNome(nome);
    docente.setToken(token);
    docente.setNrConta(nrDocente);

    docenteRepository.save(docente);
  }

  public void createEmpresa(String nome, int nrEmpresa) {

    Empresa empresa = new Empresa();
    empresa.setNome(nome);
    empresa.setNrEmpresa(nrEmpresa);

    empresaRepository.save(empresa);
  }

  public void createOrientadorExterno(String nome, String token, int nrEmpresario, Empresa empresa)
      throws UserAlreadyExistsException {

    if (alunoRepository.findByNrConta(nrEmpresario) != null
        || docenteRepository.findByNrConta(nrEmpresario) != null
        || orientadorExternoRepository.findByNrConta(nrEmpresario) != null
        || administradorRepository.findByNrConta(nrEmpresario) != null
        || presidenteRepository.findByNrConta(nrEmpresario) != null)
      throw new UserAlreadyExistsException("Account number " + nrEmpresario + " already exists!");
    OrientadorExterno orientadorExterno = new OrientadorExterno();
    orientadorExterno.setNome(nome);
    orientadorExterno.setToken(token);
    orientadorExterno.setNrConta(nrEmpresario);
    orientadorExterno.setEmpresa(empresa);

    orientadorExternoRepository.save(orientadorExterno);
  }

  public void createAdministrador(String nome, String token, int nrAdministrador) {
    Administrador administrador = new Administrador();
    administrador.setNome(nome);
    administrador.setToken(token);
    administrador.setNrConta(nrAdministrador);

    administradorRepository.save(administrador);
  }

  public void createPresidente(String nome, String token, int nrPresidente) {
    Presidente presidente = new Presidente();
    presidente.setNome(nome);
    presidente.setToken(token);
    presidente.setNrConta(nrPresidente);

    presidenteRepository.save(presidente);
  }

  public String getToken(int nrConta) {
    Docente docente = docenteRepository.findByNrConta(nrConta);
    if (docente != null) return docente.getToken();

    OrientadorExterno orientadorExterno = orientadorExternoRepository.findByNrConta(nrConta);
    if (orientadorExterno != null) return orientadorExterno.getToken();

    Administrador administrador = administradorRepository.findByNrConta(nrConta);
    if (administrador != null) return administrador.getToken();

    Presidente presidente = presidenteRepository.findByNrConta(nrConta);
    if (presidente != null) return presidente.getToken();

    return null;
  }

  public boolean validateTokenForAdministrador(String token) {
    return administradorRepository.findByToken(token) != null;
  }

  public boolean validateTokenForEmpresarioOrDocente(String token) {
    return orientadorExternoRepository.findByToken(token) != null
        || docenteRepository.findByToken(token) != null;
  }

  public boolean validateToken(String token) {
    return alunoRepository.findByToken(token) != null
        || docenteRepository.findByToken(token) != null
        || orientadorExternoRepository.findByToken(token) != null
        || administradorRepository.findByToken(token) != null
        || presidenteRepository.findByToken(token) != null;
  }
}
