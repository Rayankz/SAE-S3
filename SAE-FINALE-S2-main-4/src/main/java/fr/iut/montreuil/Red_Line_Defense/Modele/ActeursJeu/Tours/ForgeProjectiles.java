package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public abstract class ForgeProjectiles {
    protected Environnement e;

    public ForgeProjectiles(Environnement e){
        this.e=e;
    }
    public void creationProjectile(double x, double y, Soldat s, int vitesse, int degats, ToursOffensives tourOffensive) {
        Projectile p = générerProjectile(x, y, s,vitesse, degats, tourOffensive);
        e.ajouterProjectile(p);
        p.animationProjectile();
    }
    public abstract Projectile générerProjectile(double x, double y, Soldat s, int vitesse, int degats, ToursOffensives tourOffensive);
}
