package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Acteurs;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tour extends Acteurs {

    private IntegerProperty prix; // prix d'achat de l'acteur

    protected Environnement terrain;
    private double portee;
    private String id;
    private static int compteur;
    private String path;

    //Constructeur :
    public Tour(int x0, int y0, int pointsDeVie, Environnement e) {

        super(x0, y0, pointsDeVie);
        this.terrain = e;
    }

    public Tour(int x0, int y0, int pointsDeVie, int degats, int defense, int prix, Environnement terrain, double portée, String path) {

        super(x0, y0, pointsDeVie, degats, defense);

        this.prix = new SimpleIntegerProperty(prix);
        this.terrain = terrain;
        this.path = path;
        this.portee = portée;
        id=("t"+compteur);
        compteur++;
    }

    public void infligerDegats(int val){

        this.setPointsDeVieValue(this.getPointsDeVieValue() - val);
    }
    public Soldat ennemiÀPorter(double p) {

        for (Soldat s : terrain.getSoldats()) {

            if (s.estVivant()) {

                if (vérificationEstÀPorter(getX0Value(),getY0Value(),s.getX0Value(),s.getY0Value(),p)) {

                    return s;
                    }
                }
            }
            return null;
    }
    public boolean vérificationEstÀPorter(double x, double y, double xCible, double yCible, double p){

        double distanceX = Math.abs(xCible - x);
        double distanceY = Math.abs(yCible - y);
        double distanceTotale = distanceX + distanceY;

        return distanceTotale <= p;

    }
    public abstract void agit(int n);
    public Environnement getTerrain() {

        return this.terrain;
    }
    public void setTerrain(Environnement terrain) {

        this.terrain = terrain;
    }
    public String getId() {

        return this.id;
    }
    public int getPrixValue() {

        return this.prix.get();
    }
    public double getPortée() {

        return this.portee;
    }
    public void setPortée(double portee) {

        this.portee = portee;
    }
    public String getPath() {

        return this.path;
    }
}
