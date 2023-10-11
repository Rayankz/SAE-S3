package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;


import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class Missile extends Blast {
    private Soldat s;
    public Missile(double x, double y, double v, int degats, Soldat s, Environnement terrain) {
        super(x, y, s.getX0Value(), s.getY0Value(), v, degats,terrain);
        this.s=s;
    }

    public void deplacement(double elapsedTime) {
        super.deplacement(elapsedTime);
        if(s.estVivant()) {
            double distance = Math.sqrt(Math.pow(s.getX0Value() - getX(), 2) + Math.pow(s.getY0Value() - getY(), 2));
            setxDirection((s.getX0Value() - getX()) / distance);
            setyDirection((s.getY0Value() - getY()) / distance);
        }
    }

}

