package pt.ul.fc.css.alunosfx;

import java.net.HttpURLConnection;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SubmitController {

  private int nrAluno;

  @FXML private Label estadoSubmissao;

  public void setNrAluno(int nrAluno) {
    this.nrAluno = nrAluno;
  }

  public void submeterProposta() {
    submeter("submeter-proposta");
  }

  public void submeterDocumentoFinal() {
    submeter("submeter-documento-final");
  }

  private void submeter(String suffix) {
    String endpoint = "http://localhost:8080/api/" + suffix;

    try {
      URL url = new URL(endpoint + "?nrAluno=" + nrAluno);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("POST");
      conn.setDoOutput(true);
      conn.setRequestProperty("Content-Type", "application/json");

      estadoSubmissao.setText("Submissão efetuada com sucesso!");
    } catch (Exception e) {
      estadoSubmissao.setText("Erro ao submeter!");
      e.printStackTrace();
    }
  }
}
