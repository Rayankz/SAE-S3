package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Acteurs;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Tour extends Acteurs {

    private IntegerProperty prix; // prix d'achat de l'acteur

    protected Environnement terrain;

    private double portee;

    private String id;

    private static int compteur;

    public Tour(int x0, int y0, int pointsDeVie,Environnement e) {
        super(x0, y0, pointsDeVie);
        this.terrain = e;
    }

    public double getPortée() {
        return portee;
    }

    public Tour(int x0, int y0, int pointsDeVie, int degats, int defense, int prix, Environnement terrain, double portee) {
        super(x0, y0, pointsDeVie, degats, defense);

        this.prix = new SimpleIntegerProperty(prix);

        this.terrain = terrain;

        this.portee = portee;

        id=("t"+compteur);

        compteur++;
    }

    public void setPortée(double n) {

        this.portee = n;
    }

    // Getter Prix
    public int getPrixValue() {
        return this.prix.getValue();
    }

    // Setter Prix
    public void setPrixValue(int val) {
        this.prix.setValue(val);
    }

    public IntegerProperty getPrixProperty() {
        return this.prix;
    }

    public void infligerDegats(int val){
        this.setPointsDeVieValue(this.getPointsDeVieValue() - val);
    }

    public Environnement getTerrain() {
        return terrain;
    }

    public Soldat ennemiÀPorter() {
            for (Soldat s : terrain.getSoldats()) {
                if (s.estVivant()) {

                    double distanceX = Math.abs(s.getX0Value() - getX0Value());
                    double distanceY = Math.abs(s.getY0Value() - getY0Value());
                    double distanceTotale = distanceX + distanceY;

                    if (distanceTotale <= portee) {
                        return s;
                    }
                }
            }
            return null;
        }
    public boolean vérificationEstÀPorter(double x,double y){
            double distanceX = Math.abs(x - getX0Value());
            double distanceY = Math.abs(y - getY0Value());
            double distanceTotale = distanceX + distanceY;

            if (distanceTotale <= portee) {
                return true;
            }
            return false;
    }

    public String getId() {
        return id;
    }

    public abstract void agit(int n);
}
