module com.example.tower_defense {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.media;

    opens fr.iut.montreuil.Red_Line_Defense to javafx.fxml;
    exports fr.iut.montreuil.Red_Line_Defense;
    exports fr.iut.montreuil.Red_Line_Defense.Controleurs;
    opens fr.iut.montreuil.Red_Line_Defense.Controleurs to javafx.fxml;
    exports fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;
    opens fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners to javafx.fxml;
    exports fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils;
    opens fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils to javafx.fxml;
}
