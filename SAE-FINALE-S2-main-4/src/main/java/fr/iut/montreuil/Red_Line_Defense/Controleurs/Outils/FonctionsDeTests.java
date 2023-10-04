package fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.GameLoop;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

public class FonctionsDeTests {

    private Scene scene;
    private Environnement env;


    public FonctionsDeTests(Environnement env, Scene scene) {
        this.env = env;
        this.scene = scene;

        testDefaite();

    }

    private void testDefaite(){
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.T) {
                env.getBasePrincipale().setPointsDeVieValue((env.getBasePrincipale().getPointsDeVieValue()- 2000));
            }
        });
    }




}
