package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeProjectiles;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Missile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.ToursOffensives;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class ForgeMissiles extends ForgeProjectiles {
    public ForgeMissiles(Environnement e) {

        super(e);
    }
    public Projectile générerProjectile(double x, double y, Soldat s, int vitesse, int degats, ToursOffensives tourOffensive) {

        return new Missile(x, y, vitesse, degats, s, super.e, tourOffensive);
    }
}
