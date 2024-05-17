package pt.ul.fc.css.alunosfx;

import com.google.gson.Gson;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pt.ul.fc.css.alunosfx.presentation.model.AlunoRead;

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
            AlunoRead aluno = gson.fromJson(responseContent.toString(), AlunoRead.class);
            nomeAluno.setText(aluno.getNome());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
