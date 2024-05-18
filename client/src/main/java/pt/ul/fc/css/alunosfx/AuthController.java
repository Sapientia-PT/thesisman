package pt.ul.fc.css.alunosfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class AuthController {
  @FXML private TextField input;

  @FXML
  protected void onLoginClick() {
    try {
      int nrAluno = Integer.parseInt(input.getText());
      FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-view.fxml"));
      Parent root = loader.load();
      MenuController menuController = loader.getController();
      menuController.setNrAluno(nrAluno);
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.setResizable(false);
      stage.show();
    } catch (NumberFormatException e) {
      System.out.println("Invalid number format");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void initialize() {
    input.setOnKeyReleased(
        event -> {
          if (event.getCode() == KeyCode.ENTER) onLoginClick();
        });
  }
}
