package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;


import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class Boulet extends Blast {

    public Boulet(double x, double y, double xCible, double yCible, double v, int degats, Environnement terrain) {
        super(x, y, xCible, yCible, v, degats, terrain);
    }
}