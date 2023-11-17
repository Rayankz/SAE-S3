package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;


import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeProjectiles.ForgeProjectilesSimple;

public class TourSniper extends ToursOffensives {
    public TourSniper(int x0, int y0, Environnement environnement) {
        super(x0, y0, 500, 500, 5, 600, environnement, 5,1000,200, "/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/sniperPosable.png",new ForgeProjectilesSimple(environnement));
    }

}
