package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;

/**
 * This class represents a DTO for an Tema enabling the secure data transfer between endpoints.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class TemaDTO {

  private long Id;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  private String titulo;
  private String descricao;
  private float remunMensal;

  private AlunoDTO alunoDTO;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public float getRemunMensal() {
    return remunMensal;
  }

  public void setRemunMensal(float remunMensal) {
    this.remunMensal = remunMensal;
  }

  public AlunoDTO getAluno() {
    return alunoDTO;
  }

  public void setAluno(AlunoDTO alunoDTO) {
    this.alunoDTO = alunoDTO;
  }
}
