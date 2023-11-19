package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.ToursOffensives;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;

import javafx.beans.property.SimpleDoubleProperty;

public class Projectile {
    private final DoubleProperty x, y, xCible, yCible;
    private double xDirection, yDirection, v;
    private final Soldat s;
    private Environnement environnement;
    private boolean touché;
    private final int degats;
    private final String id;
    private ToursOffensives tourLauncher;
    public static int compteur = 1;

    private String path;

    public Projectile(double x, double y, Soldat s, double v, int degats, Environnement environnement, ToursOffensives tourLauncher, String path) {

        this.x = new SimpleDoubleProperty(x);

        this.y = new SimpleDoubleProperty(y);

        this.s=s;

        xCible = new SimpleDoubleProperty(s.getX0Value());

        yCible = new SimpleDoubleProperty(s.getY0Value());

        this.v = v;

        this.degats = degats;

        this.environnement = environnement;

        this.id=("p"+compteur);

        compteur++;

        touché = false;

        this.tourLauncher = tourLauncher;

        setDirection();

        this.path = path;
    }
    public void setDirection() {

        double distance = Math.sqrt(Math.pow(getxCible() - getX(), 2) + Math.pow(getyCible() - getY(), 2));
        this.xDirection = (getxCible() - getX()) / distance;
        this.yDirection = (getyCible() - getY()) / distance;
    }
    public boolean isTouché() {

        return this.touché;
    }
    public void setTouché(boolean touché) {

        this.touché = touché;
    }
    public void deplacement(double elapsedTime) {

        double deltaX = getxDirection() * getV() *elapsedTime;
        double deltaY = getyDirection() * getV() *elapsedTime;

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
                    if (tourLauncher.vérificationEstÀPorter(getX(),getY(),s.getX0Value(),s.getY0Value(),15)) {
                        getEnvironnement().supprimerProjectile(p);
                        s.setPointsDeVieValue((s.getPointsDeVieValue() - getDegats()) * (1 - ( s.getDefenseValue() / 100))); // Degats * le pourcentage de réduction de degats
                        setTouché(true);
                    }
                    if (p.getX() > 840 || (p.getX() <= 0 || (p.getY() > 480 || p.getY() <= 0))) {
                        getEnvironnement().supprimerProjectile(p);
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
    public double calculerAngle(double x, double y, double xCible, double yCible) {

        return Math.atan2(yCible - y, xCible - x);
    }
    public double getxCible() {
        return this.xCible.get();
    }
    public double getyCible() {
        return this.yCible.get();
    }
    public DoubleProperty yCibleProperty() {
        return this.yCible;
    }
    public double getxDirection() {
        return this.xDirection;
    }
    public double getyDirection() {
        return this.yDirection;
    }
    public double getV() {
        return this.v;
    }
    public DoubleProperty xProperty() {
        return this.x;
    }
    public DoubleProperty yProperty() {
        return this.y;
    }
    public double getX() {
        return this.x.getValue();
    }
    public double getY() {
        return this.y.getValue();
    }
    public void setX(double x) {
        this.x.set(x);
    }
    public void setY(double y) {
        this.y.set(y);
    }
    public String getId() {
        return this.id;
    }
    public void setEnvironnement(Environnement e){
        this.environnement = e;
    }
    public int getDegats() {
        return this.degats;
    }
    public Environnement getEnvironnement() {
        return this.environnement;
    }
    public Soldat getS() {
        return this.s;
    }
    public String getPath() {

        return this.path;
    }
}