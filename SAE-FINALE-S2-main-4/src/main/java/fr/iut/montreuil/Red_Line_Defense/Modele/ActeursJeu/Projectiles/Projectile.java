package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;

import javafx.beans.property.SimpleDoubleProperty;

public abstract class Projectile {
    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty xCible;
    private DoubleProperty yCible;
    private double xDirection;
    private double yDirection;
    private double v;//Vitesse de l'obus

    private Environnement terrain;
    private boolean touché;

    private int degats;

    private String id;

    public static int compteur =1;

    public Projectile(double x, double y, double xCible, double yCible, double v, int degats, Environnement terrain) {

        this.x = new SimpleDoubleProperty(x);

        this.y = new SimpleDoubleProperty(y);

        this.xCible = new SimpleDoubleProperty(xCible);

        this.yCible = new SimpleDoubleProperty(yCible);

        this.v = v;

        this.degats = degats;
        this.terrain=terrain;
        this.id=("p"+compteur);
        compteur++;
        touché=false;
        double distance = Math.sqrt(Math.pow(xCible - x, 2) + Math.pow(yCible - y, 2));
        this.xDirection = (xCible - x) / distance;
        this.yDirection = (yCible - y) / distance;
    }

    public boolean isTouché() {
        return touché;
    }

    public void setTouché(boolean touché) {
        this.touché = touché;
    }

    public abstract void deplacement(double elapsedTime);

    public void animationProjectile(){
        Projectile p = this;
        AnimationTimer timer = new AnimationTimer() {

            private long lastUpdate = 0;


            @Override
            public void handle(long now) {
                if (lastUpdate > 0 && !(isTouché())) {


                    double elapsedTime = (now - lastUpdate) / 1000000000.0;

                    Soldat s = ennemiÀPorter();
                    if (s != null) {
                        getTerrain().supprimerProjectile(p);
                        s.setPointsDeVieValue((s.getPointsDeVieValue() - getDegats()) * (1 - ( s.getDefenseValue() / 100))); // Degats * le pourcentage de réduction de degats
                        setTouché(true);
                    }
                    if (p.getX() > 840 || (p.getX() <= 0 || (p.getY() > 480 || p.getY() <= 0))) {
                        getTerrain().supprimerProjectile(p);
                        setTouché(true);
                    }
                    deplacement(elapsedTime);
                }
                else if(p.isTouché()){
                    stop();
                }




                lastUpdate = now;

            }
        };

        timer.start();

    }

    public Soldat ennemiÀPorter() {
        for (Soldat s : terrain.getSoldats()) {
            if (s.estVivant()) {
                double distanceX = Math.abs(s.getX0Value() - getX());
                double distanceY = Math.abs(s.getY0Value() - getY());
                double distanceTotale = distanceX + distanceY;
                if (distanceTotale <= 10) {
                    return s;
                }
            }
        }
        return null;
    }


    public double getxCible() {
        return xCible.get();
    }

    public DoubleProperty xCibleProperty() {
        return xCible;
    }

    public double getyCible() {
        return yCible.get();
    }

    public DoubleProperty yCibleProperty() {
        return yCible;
    }

    public double getxDirection() {
        return xDirection;
    }

    public double getyDirection() {
        return yDirection;
    }

    public double getV() {
        return v;
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public double getX() {
        return x.getValue();
    }

    public double getY() {
        return y.getValue();
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public void setxCible(double xCible) {
        this.xCible.set(xCible);
    }

    public void setyCible(double yCible) {
        this.yCible.set(yCible);
    }

    public void setxDirection(double xDirection) {
        this.xDirection = xDirection;
    }

    public void setyDirection(double yDirection) {
        this.yDirection = yDirection;
    }

    public void setV(double v) {
        this.v = v;
    }

    public String getId() {
        return id;
    }

    public void setTerrain(Environnement e){
        this.terrain=e;
    }
    public int getDegats() {
        return degats;
    }
    public double calculerAngle(double x, double y, double xCible, double yCible) {
        return Math.atan2(yCible - y, xCible - x);
    }
    public Environnement getTerrain() {
        return terrain;
    }
}