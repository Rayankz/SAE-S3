package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Vagues;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueInterface;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class EcouteInterface {

    private Environnement environnement;

    private VueInterface vueInterface;

    public EcouteInterface(Environnement environnement, VueInterface vueInterface) {

        this.environnement = environnement;
        this.vueInterface = vueInterface;

        ajouterEcouteurSolde();
        ajouterEcouteurEnnemisTues();
        ajouterListenerVague();
        ajouterEcouteurNumVague();
    }

    public void ajouterEcouteurSolde() {

        this.vueInterface.getSolde().textProperty().bind(environnement.getJoueur().getSoldeJoueurProperty().asString());
    }

    public void ajouterEcouteurEnnemisTues() {

        this.vueInterface.getEnnemisTues().textProperty().bind(environnement.getEnnemisTuesProperty().asString());
    }

    public void ajouterEcouteurNumVague() {

        this.vueInterface.getVagueLabel().textProperty().bind(environnement.getVagueProperty().asString());
    }

    private void ajouterListenerVague() {

        int nbVague = 0;
        this.environnement.getVagueProperty().addListener((observable, oldValue, newValue) -> {

            environnement.getJoueur().crediterSolde(800); // Chaque Vague le Joueur Gagne 800 Berrys
            environnement.getVagues().majDefenseSoldats();
            environnement.getVagues().resetTours();
            vueInterface.boucleImagesVagues(nbVague);
        });

    }
}
