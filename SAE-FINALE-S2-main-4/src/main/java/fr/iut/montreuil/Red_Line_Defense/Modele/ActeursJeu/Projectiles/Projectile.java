package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;

import javafx.beans.property.SimpleDoubleProperty;

public class Projectile {
    private final DoubleProperty x;
    private final DoubleProperty y;
    private double xDirection;
    private double yDirection;
    private final double v;//Vitesse de l'obus
    private final Soldat s;
    private Environnement terrain;
    private boolean touché;
    private final int degats;
    private final String id;
    public static int compteur =1;

    public Projectile(double x, double y, Soldat s, double v, int degats, Environnement terrain) {

        this.x = new SimpleDoubleProperty(x);

        this.y = new SimpleDoubleProperty(y);

        this.s=s;

        this.v = v;

        this.degats = degats;

        this.terrain=terrain;

        this.id=("p"+compteur);

        compteur++;

        touché=false;

        setDirection();
    }

    public void setDirection(){
        double distance = calculeDistance();
        this.xDirection = (getxCible() - getX()) / distance;
        this.yDirection = (getyCible() - getY()) / distance;
    }

    public boolean isTouché() {
        return touché;
    }

    public void setTouché(boolean touché) {
        this.touché = touché;
    }

    public void deplacement(double elapsedTime) {
        double deltaX = getxDirection() * getV()*elapsedTime;
        double deltaY = getyDirection() * getV()*elapsedTime;

        if (!(getX()==getxCible()) || (getY()==getyCible())) {
            setX(getX() + deltaX);
            setY(getY() + deltaY);
        }
    }

    public void animationProjectile(){
        Projectile p = this;
        AnimationTimer timer = new AnimationTimer() {

            private long lastUpdate = 0;


            @Override
            public void handle(long now) {
                if (lastUpdate > 0 && !(isTouché())) {


                    double elapsedTime = (now - lastUpdate) / 1000000000.0;

                    if (ennemiÀPorter(s)!=null) {
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

    public Soldat ennemiÀPorter(Soldat s) {
            if (s.estVivant()) {
                if (calculeDistance() <= 10) {
                    return s;
                }
            }
        return null;
    }

    public double calculeDistance(){
        double distanceX = Math.abs(s.getX0Value() - getX());
        double distanceY = Math.abs(s.getY0Value() - getY());
        return distanceX + distanceY;
    }


    public double getxCible() {
        return s.getX0Value();
    }

    public double getyCible() {
        return s.getY0Value();
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

    public Soldat getS() {
        return s;
    }
}