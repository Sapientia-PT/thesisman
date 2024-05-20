package pt.ul.fc.css.alunosfx;

import java.net.HttpURLConnection;
import java.net.URL;

public class SubmitController {

  private int nrAluno;

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

      System.out.println("Response: " + conn.getResponseCode());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
