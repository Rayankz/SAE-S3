package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;


import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class Boulet extends Projectile {
    public Boulet(double x, double y, double xCible, double yCible, double v, int degats, Environnement terrain) {
        super(x, y, xCible, yCible, v,degats,terrain);
    }

    public void deplacement(double elapsedTime) {
        double deltaX = super.getxDirection() * super.getV()*elapsedTime;
        double deltaY = super.getyDirection() * super.getV()*elapsedTime;

        if (!(super.getX()==super.getxCible()) || (super.getY()==super.getyCible())) {
            setX(getX() + deltaX);
            setY(getY() + deltaY);
        }
    }
}