module pt.ul.fc.css.alunosfx.alunosfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens pt.ul.fc.css.alunosfx.alunosfx to javafx.fxml;
    exports pt.ul.fc.css.alunosfx.alunosfx;
}