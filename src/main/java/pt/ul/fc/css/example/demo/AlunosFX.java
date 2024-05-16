package pt.ul.fc.css.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AlunosFX extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    String prefix = "/pt/ul/fc/css/example/demo/";

    BorderPane root = new BorderPane();

    Scene scene = new Scene(root, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
