package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Boulet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Missile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourLanceMissile extends ToursOffensives{
    public TourLanceMissile(int x0, int y0, Environnement terrain) {
        super(x0, y0, 1000, 600, 5, 100, terrain, 15,100,150);
    }
    public void creationProjectile(Soldat s){
        Missile p = new Missile(getX0Value(), getY0Value(), getVitesseProjectile(), getDegatValue(),s, getTerrain());
        getTerrain().ajouterProjectile(p);
        p.animationProjectile();
    }
}
