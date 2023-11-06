package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Boulet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourMitrailleuse extends ToursOffensives {

    public TourMitrailleuse(int x0, int y0,Environnement terrain) {
        super(x0, y0, 800, 100, 5, 400,terrain, 1,800,75);
    }

    public Projectile creationProjectile(Soldat s){
        return new Boulet(getX0Value(), getY0Value(), s, getVitesseProjectile(), getDegatValue(), getTerrain(),this);
    }


}
