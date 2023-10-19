package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class Blast extends Projectile{

    public Blast(double x, double y, Soldat s, double v, int degats, Environnement terrain) {

        super(x, y, s, v,degats,terrain);
    }
}
