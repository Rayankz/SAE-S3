package fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {
    public static MediaPlayer mediaPlayer;
    public static void chargerMedia(Media m){
        mediaPlayer = new MediaPlayer(m);
        mediaPlayer.play();
    }
    public static void arreterMediaPlayer(){
        System.out.println("dans arreter media");
        mediaPlayer.setMute(true);
        mediaPlayer.stop();
    }
}
