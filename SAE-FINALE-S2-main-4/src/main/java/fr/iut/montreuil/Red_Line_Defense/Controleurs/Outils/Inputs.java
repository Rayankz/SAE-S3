package fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils;

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

public class Inputs {
    private GameLoop gameLoop;
    private Scene scene;
    private Pane pausePane;
    public final static String PAUSE_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ComposantesMenuPrincipal/pause.png";

    public Inputs(GameLoop gameLoop, Scene scene) {
        this.gameLoop = gameLoop;
        this.scene = scene;




        preparePauseStage();
        ((Pane) scene.getRoot()).getChildren().add(pausePane);
        pausePane.resize(scene.getWidth(), scene.getHeight());
        pauseDuJeu();

    }

    public void pauseDuJeu(){
        scene.setOnKeyPressed(event -> {
            
            if (event.getCode() == KeyCode.P) {
                System.out.println("pause");
                if (gameLoop.getTimeline().getStatus() == Animation.Status.RUNNING) {
                    gameLoop.pauseTimeline();
                    pausePane.setVisible(true);
                   
                } else {
                    pausePane.setVisible(false);
                    gameLoop.lancerTimeline();
                    
                }
            }
        });
    }


    private void preparePauseStage() {
        // Création d'un label avec le texte "PAUSE"
        Image image = loadImage(PAUSE_IMAGE_PATH);
        ImageView img = new ImageView(image);

        // Création d'un layout avec un fond semi-transparent
        pausePane = new StackPane(img);
        pausePane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.8);"); // Fond noir semi-transparent
        pausePane.setVisible(false);

        pausePane.prefWidthProperty().bind(scene.widthProperty());
        pausePane.prefHeightProperty().bind(scene.heightProperty());
    }


    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

}
