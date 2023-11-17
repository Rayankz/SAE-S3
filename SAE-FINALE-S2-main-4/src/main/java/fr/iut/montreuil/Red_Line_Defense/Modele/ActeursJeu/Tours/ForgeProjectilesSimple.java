package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class ForgeProjectilesSimple extends ForgeProjectiles {

    public ForgeProjectilesSimple(Environnement e) {
        super(e);
    }

    public Projectile générerProjectile(double x, double y, Soldat s, int vitesse, int degats, ToursOffensives tourOffensive){
        return new Projectile(x,y,s,vitesse,degats,super.e,tourOffensive);
    }
}
