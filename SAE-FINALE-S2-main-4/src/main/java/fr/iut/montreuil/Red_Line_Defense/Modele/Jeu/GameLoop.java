package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueSoldats;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.List;

public class GameLoop {

    private List<Soldat> soldats;
    private Environnement terrain;
    private Pane centerPane;
    private int tailleImage = 8;

    private Timeline timelineDeplacement;
    private VueSoldats vueSoldats;


    public GameLoop(Pane centerPane, VueSoldats vueSoldats, Environnement terrain) {
        this.centerPane = centerPane;
        this.vueSoldats = vueSoldats;
        this.terrain = terrain;
        this.soldats = terrain.getSoldats();
        timelineDeplacement = new Timeline();

        creerAnimation();
    }


    public void creerAnimation() {
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(0.17), event -> {
            terrain.unTour();
            if (terrain.getBasePrincipale().getPointsDeVieValue()<=0){
            }
        });

        timelineDeplacement.getKeyFrames().add(keyFrame2);
        timelineDeplacement.setCycleCount(Timeline.INDEFINITE);
    }

    public void lancerTimeline(){
        if (timelineDeplacement.getStatus() != Animation.Status.RUNNING)
            timelineDeplacement.play();
    }

    public void pauseTimeline(){
        if (timelineDeplacement.getStatus() == Animation.Status.RUNNING)
            timelineDeplacement.pause();
    }

    public void GameOver(){
        timelineDeplacement.stop();
    }

    public Timeline getTimeline(){  return timelineDeplacement;}



}

