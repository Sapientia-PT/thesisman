package pt.ul.fc.css.alunosfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class HelloController {
    @FXML
    private TextField input;

    @FXML
    protected void onLoginClick() {
        input.setText("");
    }

    @FXML
    public void initialize() {
        input.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER)
                onLoginClick();
        });
    }
}