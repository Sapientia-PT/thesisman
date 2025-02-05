package pt.ul.fc.css.example.demo.business.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ul.fc.css.example.demo.business.handlers.UtilizadorHandler;
import pt.ul.fc.css.example.demo.business.repository.*;
import pt.ul.fc.css.example.demo.business.services.DTOs.*;
import pt.ul.fc.css.example.demo.business.services.Exceptions.NotFoundException;
import pt.ul.fc.css.example.demo.business.services.Exceptions.UserAlreadyExistsException;
import pt.ul.fc.css.example.demo.entities.*;

/**
 * This class reprents the Utilizador Service. Handles the logic for calling all the handlers
 * related to the repositories.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Service
public class UtilizadorService {

  @Autowired private AlunoRepository alunoRepository;
  @Autowired private DocenteRepository docenteRepository;
  @Autowired private EmpresaRepository empresaRepository;
  @Autowired private OrientadorExternoRepository orientadorExternoRepository;
  @Autowired private AdministradorRepository administradorRepository;

  @Autowired private UtilizadorHandler utilizadorHandler;

  @Autowired private TokenService tokenService;

  public String createAluno(String nome, int nrAluno, float media)
      throws UserAlreadyExistsException {
    Aluno aluno = alunoRepository.findByNrConta(nrAluno);
    if (aluno != null)
      throw new UserAlreadyExistsException("Aluno with nrAluno " + nrAluno + " already exists");

    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createAluno(nome, generatedToken, nrAluno, media);
    return generatedToken;
  }

  public AlunoDTO getAluno(int nrAluno) throws NotFoundException {
    Aluno aluno = alunoRepository.findByNrConta(nrAluno);
    if (aluno == null) throw new NotFoundException("Aluno with number " + nrAluno + " not found!");
    return alunoToDTO(aluno);
  }

  public String getToken(int nrConta) {
    return utilizadorHandler.getToken(nrConta);
  }

  public List<AlunoDTO> getAlunos() {
    return alunoRepository.findAll().stream().map(this::alunoToDTO).collect(Collectors.toList());
  }

  public String createDocente(String nome, int nrDocente) throws UserAlreadyExistsException {
    Docente docente = docenteRepository.findByNrConta(nrDocente);
    if (docente != null)
      throw new UserAlreadyExistsException(
          "Docente with nrDocente " + nrDocente + " already exists");

    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createDocente(nome, generatedToken, nrDocente);
    return generatedToken;
  }

  public DocenteDTO getDocente(int nrDocente) {
    return docenteToDTO(docenteRepository.findByNrConta(nrDocente));
  }

  public EmpresaDTO createEmpresa(String nome, int nrEmpresa) {
    Empresa empresa = empresaRepository.findByNrEmpresa(nrEmpresa);
    if (empresa != null) return null;

    utilizadorHandler.createEmpresa(nome, nrEmpresa);
    return empresaToDTO(empresaRepository.findByNrEmpresa(nrEmpresa));
  }

  public EmpresaDTO getEmpresa(long id) {
    return empresaToDTO(empresaRepository.findById(id).orElse(null));
  }

  public String createOrientadorExterno(String nome, int nrEmpresario, long nrEmpresa)
      throws NotFoundException, UserAlreadyExistsException {
    Empresa empresa = empresaRepository.findByNrEmpresa(nrEmpresa);
    if (empresa == null)
      throw new NotFoundException("Empresa with number " + nrEmpresa + " not found!");

    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createOrientadorExterno(nome, generatedToken, nrEmpresario, empresa);
    return generatedToken;
  }

  public OrientadorExternoDTO getOrientadorExterno(long id) {
    return orientadorExternoToDTO(orientadorExternoRepository.findById(id).orElse(null));
  }

  public String createAdministrador(String nome, int nrAdministrador) {
    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createAdministrador(nome, generatedToken, nrAdministrador);
    return generatedToken;
  }

  public AdministradorDTO getAdministrador(long id) {
    return administradorToDTO(administradorRepository.findById(id).orElse(null));
  }

  public boolean validateTokenForAdministrador(String token) {
    return utilizadorHandler.validateTokenForAdministrador(token);
  }

  public boolean validateTokenForEmpresarioOrDocente(String token) {
    return utilizadorHandler.validateTokenForEmpresarioOrDocente(token);
  }

  private AdministradorDTO administradorToDTO(Administrador a) {
    if (a == null) return null;
    AdministradorDTO administradorDTO = new AdministradorDTO();
    administradorDTO.setId(a.getId());
    administradorDTO.setNome(a.getNome());
    administradorDTO.setNrAdministrador(a.getNrConta());
    return administradorDTO;
  }

  private EmpresaDTO empresaToDTO(Empresa e) {
    if (e == null) return null;
    EmpresaDTO empresaDTO = new EmpresaDTO();
    empresaDTO.setId(e.getId());
    empresaDTO.setNome(e.getNome());
    empresaDTO.setNrEmpresa(e.getNrEmpresa());
    return empresaDTO;
  }

  private OrientadorExternoDTO orientadorExternoToDTO(OrientadorExterno o) {
    if (o == null) return null;
    OrientadorExternoDTO orientadorExternoDTO = new OrientadorExternoDTO();
    orientadorExternoDTO.setId(o.getId());
    orientadorExternoDTO.setNome(o.getNome());
    orientadorExternoDTO.setNrEmpresario(o.getNrConta());
    orientadorExternoDTO.setEmpresa(o.getEmpresa());
    return orientadorExternoDTO;
  }

  private DocenteDTO docenteToDTO(Docente d) {
    DocenteDTO docenteDTO = new DocenteDTO();
    docenteDTO.setId(d.getId());
    docenteDTO.setNome(d.getNome());
    docenteDTO.setNrDocente(d.getNrConta());
    docenteDTO.setTeses(d.getTeses());
    return docenteDTO;
  }

  private AlunoDTO alunoToDTO(Aluno a) {
    AlunoDTO alunoDTO = new AlunoDTO();
    alunoDTO.setNrConta(a.getNrConta());
    alunoDTO.setNome(a.getNome());
    alunoDTO.setMedia(a.getMedia());
    return alunoDTO;
  }
}
