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
    private IntegerProperty longueur; // la longueur entre xo;yo et x1;y1

    protected Environnement terrain;

    private double portee;

    private String id;

    private static int compteur;

    public Tour(int x0, int y0, int pointsDeVie) {
        super(x0, y0, pointsDeVie);
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


        // initialiserLongueur();
    }

    public Tour(int x0, int y0, int pointsDeVie, int degats, int defense, Environnement terrain) {
        super(x0, y0, pointsDeVie, degats, defense);

        this.terrain = terrain;

        //initialiserLongueur();

    }

    /* public void initialiserLongueur() {

        // Calculer la distance entre (X0, Y0) et (X1, Y1)
        double deltaX = this.getX1Value() - this.getX0Value();
        double deltaY = this.getY1Value() - this.getY0Value();

        // Utiliser le théorème de Pythagore pour calculer la longueur
        int nouvelleLongueur = (int) Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Mettre à jour la longueur
        this.setLongueur(nouvelleLongueur);

    } */


    // Getter X1


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

    // Getter Longueur
    public int getLongueurValue() {
        return this.longueur.getValue();
    }

    public IntegerProperty getLongueurProperty() {
        return this.longueur;
    }

    // Setter Longueur
    public void setLongueur(int val) {
        this.longueur.setValue(val);
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
    /*public void afficherPortee(Pane p){
        Circle c = new Circle(this.getX0Value(), this.getY0Value(), this.getPortée());
        c.setStroke(Color.GREY);
        c.setFill(Color.TRANSPARENT);
        p.getChildren().add(c);
        System.out.println("portée affichée");
    }*/

    public String getId() {
        return id;
    }

    public abstract void agit(int n);
}
