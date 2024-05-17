module pt.ul.fc.css.alunosfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens pt.ul.fc.css.alunosfx to javafx.fxml;
    opens pt.ul.fc.css.alunosfx.presentation.model to com.google.gson;
    exports pt.ul.fc.css.alunosfx;
    exports pt.ul.fc.css.alunosfx.presentation.model to com.google.gson;
}