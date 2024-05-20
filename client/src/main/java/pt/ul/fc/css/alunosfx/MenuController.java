package pt.ul.fc.css.alunosfx;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import pt.ul.fc.css.alunosfx.presentation.model.AlunoRead;
import pt.ul.fc.css.alunosfx.presentation.model.TemaRead;

public class MenuController {

  @FXML private Label nomeAluno;

  @FXML private ListView<TemaRead> listaTemas;

  private int nrAluno;

  private List<String> nomesTemasEscolhidos;

  public void setNrAluno(int nrAluno) throws IOException {
    this.nrAluno = nrAluno;
    getNomeAluno();
    getTemas();
  }

  private void getNomeAluno() throws IOException {
    String endpoint = "http://localhost:8080/api/aluno/" + nrAluno;

    URL url = new URL(endpoint);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");

    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    StringBuilder responseContent = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      responseContent.append(line);
    }
    reader.close();

    Gson gson = new Gson();
    AlunoRead aluno = gson.fromJson(responseContent.toString(), AlunoRead.class);
    nomeAluno.setText(aluno.getNome());
  }

  public void getTemas() {
    String endpoint = "http://localhost:8080/api/temas";

    try {
      URL url = new URL(endpoint);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");

      BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      StringBuilder responseContent = new StringBuilder();
      while ((line = reader.readLine()) != null) {
        responseContent.append(line);
      }
      reader.close();

      Gson gson = new Gson();
      TemaRead[] temas = gson.fromJson(responseContent.toString(), TemaRead[].class);
      listaTemas.getItems().clear();
      listaTemas.getItems().addAll(temas);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void initialize() {
    nomesTemasEscolhidos = new LinkedList<>();
    nomeAluno.setText("");
    // TODO: listaTemas.getItems().clear(); ??

    listaTemas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    listaTemas
        .getSelectionModel()
        .getSelectedItems()
        .addListener(
            (ListChangeListener<TemaRead>)
                change -> {
                  while (change.next()) {
                    if (change.wasAdded())
                      for (TemaRead tema : change.getAddedSubList())
                        nomesTemasEscolhidos.add(tema.getTitulo());

                    if (change.wasRemoved())
                      for (TemaRead tema : change.getRemoved())
                        nomesTemasEscolhidos.remove(tema.getTitulo());
                  }
                  ;
                });
  }

  public void sendTemas() {

    String endpoint = "http://localhost:8080/api/tema";

    for (String tema : nomesTemasEscolhidos) {
      try {
        String formattedTitulo = tema.replace(" ", "%20");
        URL url = new URL(endpoint + "?titulo=" + formattedTitulo + "&nrAluno=" + nrAluno);
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

  public void cancelarTemas() {
    String endpoint = "http://localhost:8080/api/tema";

    for (String tema : nomesTemasEscolhidos) {
      try {
        String formattedTitulo = tema.replace(" ", "%20");
        URL url = new URL(endpoint + "?titulo=" + formattedTitulo + "&nrAluno=" + nrAluno);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        System.out.println("Response: " + conn.getResponseCode());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  protected void onSubmissaoClick() {
    if (nomesTemasEscolhidos.isEmpty()) return;

    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("submit-view.fxml"));
      Parent root = loader.load();
      SubmitController submitController = loader.getController();
      submitController.setNrAluno(nrAluno);
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.setResizable(false);
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
