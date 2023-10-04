package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.Controleur;
import fr.iut.montreuil.Red_Line_Defense.Controleurs.ControleurDefaite;
import fr.iut.montreuil.Red_Line_Defense.Controleurs.ControleurVictoire;
import fr.iut.montreuil.Red_Line_Defense.Main;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Vagues;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueInterface;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class EcouteVictoireEtDefaite {

    private Joueur joueur;
    private Environnement terrain;

    private VueInterface vueInterface;

    private Vagues vagues;

    private Controleur c;

    private IntegerProperty vague;

    public EcouteVictoireEtDefaite(Environnement terrain, VueInterface vueInterface, Controleur c) {
        this.terrain = terrain;
        this.joueur = terrain.getJoueur();
        this.vague = terrain.getVagueProperty();
        this.vagues = terrain.getVagues();
        this.vueInterface = vueInterface;
        this.c = c;
        ajouterEcouteurVictoire();
        ajouterEcouteurDefaite();
    }



    private void ajouterEcouteurVictoire() {

        this.vague.addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > 5) {
                ajouterVictoire();
            }
        });
    }


    public void ajouterVictoire(){
        URL url = Main.class.getResource("Vues/VueVictoire.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ControleurVictoire controleur = loader.getController(); // Retrieve the controller instance
        Stage stage = c.getStage();
        Scene scene = new Scene(root, 940, 560);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
        stage.show();
    }

    private void ajouterEcouteurDefaite() {

        this.vague.addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() < 1) {
                if (c != null && c.getScene() != null && c.getScene().getWindow() != null) {
                    vueInterface.ajouterDefaite(c.getStage());
                }
            }
        });
    }




}
