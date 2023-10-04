package fr.iut.montreuil.Red_Line_Defense.Controleurs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurDefaite implements Initializable {
    private Stage stage;
    private Parent root;
    private MediaPlayer mediaPlayerLose;
    private Media mediaLose;
    public static final String WIN_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/gameOver.mp3";



    @FXML
    private void onRejouerButtonClick(MouseEvent event) throws IOException {
        mediaPlayerLose.stop();
        System.out.println("Media arrêté");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueDeJeu.fxml"));
        root = loader.load();
        Controleur controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 940, 560);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);

        controleur.initializeInputs();
    }
    @FXML
    private void onMenuPrincipalClicked(MouseEvent event) throws IOException {
        mediaPlayerLose.stop();
        System.out.println("Media arrêté");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueMenuPrincipal.fxml"));
        Parent roott = loader.load();
        ControleurMP controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(roott, 940, 560);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaLose = new Media(getClass().getResource(WIN_PATH).toString());
        mediaPlayerLose = new MediaPlayer(mediaLose);
        mediaPlayerLose.play();

    }
}
