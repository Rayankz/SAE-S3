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

    private Joueur joueur;
    private Environnement terrain;

    private VueInterface vueInterface;

    private Vagues vagues;


    private IntegerProperty vague;

    public EcouteInterface(Environnement terrain, VueInterface vueInterface) {
        this.terrain = terrain;
        this.joueur = terrain.getJoueur();
        this.vague = terrain.getVagueProperty();
        this.vagues = terrain.getVagues();
        this.vueInterface = vueInterface;
        ajouterEcouteurSolde();
        ajouterEcouteurEnnemisTues();
        ajouterListenerVague();
        ajouterEcouteurNumVague();
    }

    public void ajouterEcouteurSolde() {

        this.joueur.getSoldeJoueurProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                vueInterface.getSolde().setText(String.valueOf(newValue));
            }
        });
    }

    public void ajouterEcouteurEnnemisTues() {

        this.terrain.getEnnemisTuesProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                vueInterface.getEnnemisTues().setText(String.valueOf(newValue));
            }
        });
    }
    public void ajouterEcouteurNumVague() {

        this.terrain.getVagueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                vueInterface.getVagueLabel().setText(String.valueOf(newValue));
            }
        });
    }

    private void ajouterListenerVague() {
        int nbvague = 0;
        this.vague.addListener((observable, oldValue, newValue) -> {
            joueur.crediterSolde(800); // Chaque Vague le Joueur Gagne 800 Berrys
            vagues.majDefenseSoldats();
            vagues.resetTours();
            vueInterface.boucleImagesVagues(nbvague);
        });

    }




}
