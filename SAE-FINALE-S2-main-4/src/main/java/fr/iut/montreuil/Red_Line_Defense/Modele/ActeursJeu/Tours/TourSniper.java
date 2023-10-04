package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;


import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Blast;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Boulet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourSniper extends ToursOffensives {
    public TourSniper(int x0, int y0, Environnement terrain) {
        super(x0, y0, 500, 500, 5, 600, terrain, 7,1000,400); // 50 tirs par minutes
    }
    public void creationProjectile(Soldat s){
        Blast p = new Blast(getX0Value(), getY0Value(), s.getX0Value(),s.getY0Value(), getVitesseProjectile(), getDegatValue(), getTerrain());
        getTerrain().ajouterProjectile(p);
        p.animationProjectile();
    }

}
