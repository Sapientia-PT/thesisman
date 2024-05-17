package pt.ul.fc.css.alunosfx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MenuController {

    @FXML
    private Label nomeAluno;

    @FXML
    private ListView<String> listaTemas;

    private int nrAluno;

    public void setNrAluno(int nrAluno) {
        this.nrAluno = nrAluno;
        getNomeAluno();
    }

    private void getNomeAluno() {
        String endpoint = "http://localhost:8080/api/aluno/" + nrAluno;

        new Thread(() -> {
            try {
                URL url = new URL(endpoint);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // Parse JSON response manually
                    String jsonResponse = response.toString();
                    String nomeAlunoResponse = extractNomeFromJson(jsonResponse);

                    // Update the UI on the JavaFX Application Thread
                    Platform.runLater(() -> nomeAluno.setText(nomeAlunoResponse));
                } else {
                    System.out.println("GET request failed: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Simple method to extract 'nome' from JSON response
    private String extractNomeFromJson(String jsonResponse) {
        String nomeKey = "\"nome\":\"";
        int startIndex = jsonResponse.indexOf(nomeKey) + nomeKey.length();
        int endIndex = jsonResponse.indexOf("\"", startIndex);
        return jsonResponse.substring(startIndex, endIndex);
    }
}
