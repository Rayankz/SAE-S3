package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeProjectiles;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Offensives.ToursOffensives;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class ForgeProjectilesSniper extends ForgeProjectiles {

    public ForgeProjectilesSniper(Environnement e) {

        super(e);
    }

    public Projectile générerProjectile(double x, double y, Soldat s, int vitesse, int degats, ToursOffensives tourOffensive) {

        return new Projectile(x, y, s, vitesse, degats, super.e, tourOffensive, "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/blast.gif");
    }
}
