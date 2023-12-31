package fr.iut.montreuil.Red_Line_Defense.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Joueur {

    private String nomJoueur;
    private IntegerProperty soldeJoueur;

    public Joueur(String nomJ) {

        this.nomJoueur = nomJ;
        this.soldeJoueur = new SimpleIntegerProperty(2000);
        ajouterListenerSoldeJoueur();
    }
    public IntegerProperty getSoldeJoueurProperty() {

        return soldeJoueur;
    }
    public void ajouterListenerSoldeJoueur(){

        soldeJoueur.addListener((observable, oldValue, newValue) -> {
            if ((newValue.intValue()) <= 0) {

                soldeJoueur.setValue(0);
                System.out.println("Vous êtes pauvre");
            }
        });
    }
    public int getSoldeJoueurValue() {

        return soldeJoueur.getValue();
    }
    public void créditerSolde(int val) {

        this.soldeJoueur.setValue(this.soldeJoueur.getValue() + val);
    }
    public void débiterSolde(int val) {

        this.soldeJoueur.setValue(this.soldeJoueur.getValue() - val);
    }
}
