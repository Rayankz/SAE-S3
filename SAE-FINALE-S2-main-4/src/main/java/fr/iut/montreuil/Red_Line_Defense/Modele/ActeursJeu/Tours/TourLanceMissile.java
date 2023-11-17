package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Missile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourLanceMissile extends ToursOffensives {
    public TourLanceMissile(int x0, int y0, Environnement environnement) {
        super(x0, y0, 1000, 600, 5, 800, environnement, 7,100,150, "/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/mortierPosable.png", new ForgeMissiles(environnement));
    }
}
