package fr.iut.montreuil.Red_Line_Defense.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils.Audio;
import javafx.animation.KeyFrame;
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
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurMP implements Initializable {
    private Stage stage;
    private Parent root;

    private MediaPlayer mediaPlayerOpening;
    private Media mediaOpening;
    public static final String OPENING_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/opening-full.mp3";
    public static final String OUI = "/fr/iut/montreuil/Red_Line_Defense/Sons/tourBreak.mp3";
    public static final String OK = "/fr/iut/montreuil/Red_Line_Defense/Sons/ostJeu.mp3";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaOpening = new Media(getClass().getResource(OPENING_PATH).toString());
        Audio.chargerMedia(mediaOpening);
        /*mediaOpening = new Media(getClass().getResource(OPENING_PATH).toString());
        mediaPlayerOpening = new MediaPlayer(mediaOpening);
        mediaPlayerOpening.play();
      //  mediaPlayerOpening.stop();
        ediaOpening = new Media(getClass().getResource(OK).toString());
        mediaPlayerOpening = new MediaPlayer(mediaOpening);
        mediaPlayerOpening.play();*/
    }
    @FXML
    private void onJouerButtonClick(MouseEvent event) throws IOException {
        //Audio.arreterMediaPlayer();
        System.out.println("media stop");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueDeJeu.fxml"));
        root = loader.load();
        Controleur controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 940, 560);
        stage.setResizable(false);
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
        stage.show();

        controleur.initializeInputs();

    }
    @FXML
    private void onAideButtonClick(MouseEvent event) throws IOException {
        System.out.println("media stop");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueAide.fxml"));
        root = loader.load();
        ControleurAide controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 940, 560);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
        stage.show();
    }

}
