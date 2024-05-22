package pt.ul.fc.css.example.demo.business.services.DTOs;

import org.springframework.stereotype.Component;

/**
 * This class represents a DTO for an aluno enabling the secure data transfer between endpoints.
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Component
public class AlunoDTO {

  private int nrConta;

  private String nome;

  private float media;

  public int getNrConta() {
    return nrConta;
  }

  public void setNrConta(int nrConta) {
    this.nrConta = nrConta;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public float getMedia() {
    return media;
  }

  public void setMedia(float media) {
    this.media = media;
  }
}
