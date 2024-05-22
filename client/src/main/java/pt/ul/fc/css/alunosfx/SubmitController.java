package pt.ul.fc.css.alunosfx;

import java.net.HttpURLConnection;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SubmitController {

  private int nrAluno;

  @FXML private Label estadoSubmissao;

  private boolean submittedFinal = false;

  public void setNrAluno(int nrAluno) {
    this.nrAluno = nrAluno;
  }

  public void submeterProposta() {
    submeter("submeter-proposta");
  }

  public void submeterDocumentoFinal() {
    if (!submittedFinal) {
      submeter("submeter-documento-final");
      submittedFinal = true;
    } else estadoSubmissao.setText("Documento final já foi submetido!");
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
      System.out.println(conn.getResponseCode());
    } catch (Exception e) {
      estadoSubmissao.setText("Erro ao submeter!");
      e.printStackTrace();
    }
  }
}
