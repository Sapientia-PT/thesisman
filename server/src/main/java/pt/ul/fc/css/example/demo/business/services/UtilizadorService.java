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

@Service
public class UtilizadorService {

  @Autowired private AlunoRepository alunoRepository;
  @Autowired private DocenteRepository docenteRepository;
  @Autowired private EmpresaRepository empresaRepository;
  @Autowired private OrientadorExternoRepository orientadorExternoRepository;
  @Autowired private AdministradorRepository administradorRepository;
  @Autowired private PresidenteRepository presidenteRepository;

  @Autowired private UtilizadorHandler utilizadorHandler;

  @Autowired private TokenService tokenService;

  public String createAluno(String nome, int nrAluno, float media)
      throws UserAlreadyExistsException {
    Aluno aluno = alunoRepository.findByNrAluno(nrAluno);
    if (aluno != null)
      throw new UserAlreadyExistsException("Aluno with nrAluno " + nrAluno + " already exists");

    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createAluno(nome, generatedToken, nrAluno, media);
    return generatedToken;
  }

  public AlunoDTO getAluno(int nrAluno) {
    return alunoToDTO(alunoRepository.findByNrAluno(nrAluno));
  }

  public List<AlunoDTO> getAlunos() {
    return alunoRepository.findAll().stream().map(this::alunoToDTO).collect(Collectors.toList());
  }

  public String createDocente(String nome, int nrDocente) throws UserAlreadyExistsException {
    Docente docente = docenteRepository.findByNrDocente(nrDocente);
    if (docente != null)
      throw new UserAlreadyExistsException(
          "Docente with nrDocente " + nrDocente + " already exists");

    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createDocente(nome, generatedToken, nrDocente);
    return generatedToken;
  }

  public DocenteDTO getDocente(int nrDocente) {
    return docenteToDTO(docenteRepository.findByNrDocente(nrDocente));
  }

  public String createOrientadorExterno(String nome, long nrEmpresa) throws NotFoundException {
    Empresa empresa = empresaRepository.findByNrEmpresa(nrEmpresa);
    if (empresa == null)
      throw new NotFoundException("Empresa with nrEmpresa " + nrEmpresa + " not found");

    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createOrientadorExterno(nome, generatedToken, empresa);
    return generatedToken;
  }

  public OrientadorExternoDTO getOrientadorExterno(long id) {
    return orientadorExternoToDTO(orientadorExternoRepository.findById(id).orElse(null));
  }

  public String createAdministrador(String nome) {
    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createAdministrador(nome, generatedToken);
    return generatedToken;
  }

  public AdministradorDTO getAdministrador(long id) {
    return administradorToDTO(administradorRepository.findById(id).orElse(null));
  }

  public String createPresidente(String nome) {
    String generatedToken = tokenService.generateToken();
    utilizadorHandler.createPresidente(nome, generatedToken);
    return generatedToken;
  }

  public PresidenteDTO getPresidente(long id) {
    return presidenteToDTO(presidenteRepository.findById(id).orElse(null));
  }

  private AdministradorDTO administradorToDTO(Administrador a) {
    if (a == null) return null;
    AdministradorDTO administradorDTO = new AdministradorDTO();
    administradorDTO.setId(a.getId());
    administradorDTO.setNome(a.getNome());
    return administradorDTO;
  }

  private PresidenteDTO presidenteToDTO(Presidente p) {
    if (p == null) return null;
    PresidenteDTO presidenteDTO = new PresidenteDTO();
    presidenteDTO.setId(p.getId());
    presidenteDTO.setNome(p.getNome());
    return presidenteDTO;
  }

  private OrientadorExternoDTO orientadorExternoToDTO(OrientadorExterno o) {
    if (o == null) return null;
    OrientadorExternoDTO orientadorExternoDTO = new OrientadorExternoDTO();
    orientadorExternoDTO.setId(o.getId());
    orientadorExternoDTO.setNome(o.getNome());
    orientadorExternoDTO.setEmpresa(o.getEmpresa());
    return orientadorExternoDTO;
  }

  private DocenteDTO docenteToDTO(Docente d) {
    DocenteDTO docenteDTO = new DocenteDTO();
    docenteDTO.setId(d.getId());
    docenteDTO.setNome(d.getNome());
    docenteDTO.setNrDocente(d.getNrDocente());
    docenteDTO.setTeses(d.getTeses());
    return docenteDTO;
  }

  private AlunoDTO alunoToDTO(Aluno a) {
    AlunoDTO alunoDTO = new AlunoDTO();
    alunoDTO.setId(a.getId());
    alunoDTO.setNome(a.getNome());
    alunoDTO.setNrAluno(a.getNrAluno());
    alunoDTO.setMedia(a.getMedia());
    return alunoDTO;
  }
}
