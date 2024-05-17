module pt.ul.fc.css.alunosfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens pt.ul.fc.css.alunosfx to javafx.fxml;
    exports pt.ul.fc.css.alunosfx;
}