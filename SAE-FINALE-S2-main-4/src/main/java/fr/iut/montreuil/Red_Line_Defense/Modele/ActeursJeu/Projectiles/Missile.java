package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;


import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class Missile extends Projectile {

    public Missile(double x, double y, double v, int degats, Soldat s, Environnement terrain) {

        super(x, y, s, v, degats,terrain);
    }

    public void deplacement(double elapsedTime) {

        super.deplacement(elapsedTime);

        if(getS().estVivant()) {

            setDirection();
        }
    }

}

