package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;


import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.ToursOffensives;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class Missile extends Projectile {

    public Missile(double x, double y, double v, int degats, Soldat s, Environnement terrain, ToursOffensives tour, String path) {

        super(x, y, s, v, degats,terrain, tour, path);
    }
    public void deplacement(double elapsedTime) {

        super.deplacement(elapsedTime);

        if(getS().estVivant()) {

            setDirection();
        }
    }
    public double getxCible(){
        return getS().getX0Value();
    }
    public double getyCible(){
        return getS().getY0Value();
    }
}

