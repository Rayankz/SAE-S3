package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteurs {


    private DoubleProperty X0, Y0; // position de l'axe de rotation
    private IntegerProperty pointsDeVie, degats; // les noms parlent d'eux meme
    private IntegerProperty defense; // pourcentage de réduction des dégats


    public Acteurs(double x0, double y0, int pointsDeVie, int degats, int defense) {

        // Coordonnées
        this.X0 = new SimpleDoubleProperty(x0);
        this.Y0 = new SimpleDoubleProperty(y0);


        // Statistiques
        this.pointsDeVie = new SimpleIntegerProperty(pointsDeVie);
        this.degats = new SimpleIntegerProperty(degats);
        this.defense = new SimpleIntegerProperty(defense);


    }

    public Acteurs(double x0, double y0) {

        // Coordonnées
        this.X0 = new SimpleDoubleProperty(x0);
        this.Y0 = new SimpleDoubleProperty(y0);
    }

    public Acteurs(int x0, int y0, int pointsDeVie) {
        this.X0 = new SimpleDoubleProperty(x0);
        this.Y0 = new SimpleDoubleProperty(y0);
        this.pointsDeVie = new SimpleIntegerProperty(pointsDeVie);
    }

    // ______________________ GETTERS ET SETTERS ________________________________________________________________________


    // Coordonnées

    // Getters
    // x0
    public double getX0Value() {
        return this.X0.getValue();
    }      // Valeur x0

    public DoubleProperty getX0Property() {
        return this.X0;
    }  // Property x0

    // y0
    public double getY0Value() {
        return this.Y0.getValue();
    }      // Valeur y0

    public DoubleProperty getY0Property() {
        return this.Y0;
    }  // Property y0


    // Setters
    // x0
    public void setX0(double val) {
        this.X0.setValue(val);
    }

    // y0
    public void setY0(double val) {
        this.Y0.setValue(val);
    }

    public void setPosition(double posX, double posY) {
        this.X0.setValue(posX);
        this.Y0.setValue(posY);
    }


    // _________________________________________________________________________________________________________________


    // Statistiques
    // Getters
    // Points De Vie
    public int getPointsDeVieValue() {
        return this.pointsDeVie.getValue();
    }

    // Setters
    // Points De Vie
    public void setPointsDeVieValue(int val) {
        this.pointsDeVie.setValue(val);
    }

    public IntegerProperty getPointsDeVieProperty() {
        return this.pointsDeVie;
    }

    // Degats
    public int getDegatValue() {
        return this.degats.getValue();
    }

    public IntegerProperty getDegatsProperty() {
        return this.degats;
    }

    // Defense
    public int getDefenseValue() {
        return this.defense.getValue();
    }

    // Defense
    public void setDefenseValue(int val) {
        this.defense.setValue(val);
    }

    public IntegerProperty getDefenseProperty() {
        return this.defense;
    }

    // Degats
    public void setDegatsValue(int val) {
        this.degats.setValue(val);
    }


    // _________________________________________________________________________________________________________________

    public void soigner(int val) {
        // Ajouter les points de soin aux points de vie actuels de l'acteur
        int nouvelleVie = this.getPointsDeVieValue() + val;

        // Mettre à jour les points de vie de l'acteur
        this.setPointsDeVieValue(nouvelleVie);
    }


}
